package com.example.gccoffee.Service;

import com.example.gccoffee.Exception.NoSuchOrderException;
import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Repository.OrderRepository;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderItem> jsonToOrderItems(Object json) {
        System.out.println("json = " + json);
        System.out.println("json type = " + json.getClass());
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            for (Object o : (List) json) {
                orderItems.add(OrderItem.createOrderItem(
                        productRepository.findById(UUID.fromString(((HashMap<String, String>) o).get("productId"))),
                        //2022-10-8_yeoooo : orderItem이 save되지 않았기 때문에 id가 generated 되지 않음 -> null
                        //따라서 orderTest()에서 호출했을 경우 해당 구문을 실행할 수 없음
                        ((HashMap<String, Integer>) o).get("quantity")
                ));
            }
        } catch (NullPointerException e) {
            for (Object o : (List) json) {
                Map<String, ?> map = (Map<String, String>) ((HashMap<String, ?>) o).get("product");
                orderItems.add(OrderItem.createOrderItem(
                        productRepository.findById(UUID.fromString(map.get("productId").toString())
                        ), (int) map.get("quantity")));
            }
        }

/**
 * on actual json => [OrderItem(id=null, product=Product(productId=7148d468-4714-11ed-9d89-2ba0a24d9a1f, productName=커피짱2, category=BEAN, description=이 콩은 두 번째로 맛있습니다., price=100, quantity=5), order=null, orderPrice=100, count=1)]
 * class java.util.ArrayList
 * on test json => [{createdAt=null, updatedAt=null, id=null, product={createdAt=2022-10-08T23:22:43.105233, updatedAt=2022-10-08T23:22:43.105233, productId=feb8db25-4491-440f-985d-fba59732cb2f, productName=테스트콩, category=BEAN, description=테스트용, price=1000, quantity=14}, order=null, orderPrice=1000, count=1, totalPrice=1000}]
 * class java.util.ArrayList
 */
        return orderItems;
    }

    @Override
    @Transactional
//    public UUID order(String email, String address, String postCode , List<OrderItem> orderItems) {
    public UUID order(OrderDTO orderDTO) {
        LocalDateTime now = LocalDateTime.now();
        Optional<Order> targetOrder;
        if(now.isAfter(now.withHour(14).withMinute(0))){
            //2022-09-19_yeoooo : 들어온 주문이 14시 이후인 경우
            targetOrder = orderRepository.findByEmailAndDayOrderAfter(orderDTO.getEmail(), now);
        }else{
            targetOrder = orderRepository.findByEmailAndDayOrder(orderDTO.getEmail(), now);
        }
        for (OrderItem o : orderDTO.getOrderItems()) {
            Optional<Product> targetProduct = productRepository.findById(o.getProduct().getProductId());
            if (targetProduct.isEmpty()){
                throw new NoSuchProductException("상품이 존재하지 않습니다.");
            }
            if (targetOrder.isEmpty()) {//2022-09-8_yeoooo : 작일 14:00 부터 당일 14:00 까지의 주문이 없으면 새 주문 생성
                targetOrder = Optional.of(Order.createOrder(orderDTO.getEmail(), orderDTO.getAddress(), orderDTO.getPostcode(), OrderStatus.ACCEPTED, o));
                log.info("New Order Created : {}", targetOrder);
            }
            else {//2022-09-8_yeoooo : 이전 주문이 있으면 해당 주문에 아이템 밀어넣기
                targetOrder.get().addOrderItem(o);
                log.info("Order Already Exists : {}", targetOrder.get().getOrderItems());
            }
            }

        return orderRepository.save(targetOrder.get()).getId();

    }


    @Override
    @Transactional
    public void cancelOrder(UUID uuid) {
        Optional<Order> foundOne = orderRepository.findById(uuid);
        if (foundOne.isEmpty()) {
            throw new NoSuchOrderException("주문이 존재하지 않습니다.");
        }else{
            foundOne.get().cancelOrder();
            log.warn("order deleted : {}", foundOne);
        }
    }

    @Override
    @Transactional
    public Order changeOrderStatus(Order order, OrderStatus orderStatus) {
        if (orderStatus == OrderStatus.CANCELLED) {
            order.cancelOrder();
        }
        return orderRepository.save(
                order.builder()
                        .dto(OrderDTO.builder()
                .id(order.getId())
                .address(order.getAddress())
                .orderStatus(orderStatus)
                .price(order.getTotalPrice())
                .orderItems(order.getOrderItems())
                .postcode(order.getPostcode())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .email(order.getEmail())
                .build())
                .build());
    }

    @Override
    @Transactional
    public Order delete(UUID id) {
        Optional<Order> target = orderRepository.findById(id);
        if (target.isEmpty()) {
            throw new NoSuchOrderException("해당 주문이 존재하지 않습니다.");
        }else{
            target.get().cancelOrder();
            orderRepository.delete(target.get());
        }
        return target.get();
    }

    @Override
    public List<Order> findByEmail(String email) {
        return orderRepository.findByEmail(email);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
    }


}

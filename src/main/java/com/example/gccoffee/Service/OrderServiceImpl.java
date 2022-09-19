package com.example.gccoffee.Service;

import com.example.gccoffee.Repository.OrderRepository;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderItem;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<OrderItem> jsonToOrderItems(Object json) {
        List<OrderItem> orderItems = new ArrayList<>();
        System.out.println("json = " + json);
        for (Object o : (List) json) {
            orderItems.add(OrderItem.createOrderItem(
                    productRepository.findById(UUID.fromString(((HashMap<String, ?>) o).get("productId").toString())),
                    Long.valueOf(((HashMap<String, Integer>) o).get("price")),
                    (int) ((HashMap<String, ?>) o).get("quantity")
            ));
        }
        return orderItems;
    }

    @Override
    @Transactional
    public Order order(String email, String address, String postCode , List<OrderItem> orderItems) {
        LocalDateTime now = LocalDateTime.now();
//        Optional<Order> targetOrder = orderRepository.findByEmailAndDayOrder(email, );
        Optional<Order> targetOrder;
//        Optional<Order> targetOrder_new = orderRepository.findByEmailAndDayOrderNew(email, LocalDateTime.now());
        if(now.isAfter(now.withHour(14).withMinute(0))){
            //2022-09-19_yeoooo : 들어온 주문이 14시 이후인 경우
            targetOrder = orderRepository.findByEmailAndDayOrderNew(email, now);
        }else{
            targetOrder = orderRepository.findByEmailAndDayOrder(email, now);
        }
        for (OrderItem o : orderItems) {
            Optional<Product> targetProduct = productRepository.findById(o.getProduct().getProductId());
            if (targetProduct.isEmpty()){
                throw new IllegalArgumentException("no such product");

            }else if(targetProduct.get().getQuantity() == 0){
                throw new IllegalArgumentException("product out of stock");
            }
                if (targetOrder.isEmpty()) {//2022-09-8_yeoooo : 작일 14:00 부터 당일 14:00 까지의 주문이 없으면 새 주문 생성
                    Order order = Order.createOrder(email, address, postCode, OrderStatus.ACCEPTED, o);
//                    o.setOrderPrice(order.getTotalPrice());
                    log.info("New Order Created : {}", order);
                    log.info("New Order Created : {}", targetOrder);
                    return orderRepository.save(order);
                }
                else {//2022-09-8_yeoooo : 이전 주문이 있으면 해당 주문에 아이템 밀어넣기
                    targetOrder.get().addOrderItem(o);
                    log.info("Order Already Exists : {}", targetOrder.get().getOrderItems());
                    return targetOrder.get();
                }
            }
        return targetOrder.get();

    }


    @Override
    @Transactional
    public void cancelOrder(UUID uuid) {
        Optional<Order> foundOne = orderRepository.findById(uuid);
        if (foundOne.isEmpty()) {
            throw new IllegalStateException("Already deleted Order");
        }else{
            foundOne.get().cancelOrder();
            log.info("order deleted : {}", foundOne);
        }
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> findByEmail(String email) {
        return orderRepository.findByEmail(email);
    }

//    @Override
//    public Order findByEmailAndDayOrder(String email, LocalDateTime localDatetime) {
//        return orderRepository.findByEmailAndDayOrder(email, localDatetime);
//    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
    }


}

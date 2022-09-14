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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Order order(String email, String address, String postCode , UUID productId, int count) {
        Optional<Order> targetOrder = orderRepository.findByEmailAndDayOrder(email, LocalDateTime.now());
        Optional<Product> targetProduct = productRepository.findById(productId);
        if (targetProduct.isEmpty()){
            throw new IllegalArgumentException("no such product");

        }else if(targetProduct.get().getQuantity() == 0){
            throw new IllegalArgumentException("product out of stock");
        }
        else {
            OrderItem orderItem = OrderItem.createOrderItem(targetProduct.get(), targetProduct.get().getPrice(), count);

            if (targetOrder.isEmpty()) {//2022-09-8_yeoooo : 작일 14:00 부터 당일 14:00 까지의 주문이 없으면 새 주문 생성
                Order order = Order.createOrder(email, address, postCode, OrderStatus.ACCEPTED, orderItem);
                log.info("New Order Created : {}", order);
                return orderRepository.save(order);

            } else {//2022-09-8_yeoooo : 이전 주문이 있으면 해당 주문에 아이템 밀어넣기
                targetOrder.get().addOrderItem(orderItem);
                log.info("Order Already Exists : {}", targetOrder.get().getOrderItems());
                return targetOrder.get();
            }
        }
    }

    @Override
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


}

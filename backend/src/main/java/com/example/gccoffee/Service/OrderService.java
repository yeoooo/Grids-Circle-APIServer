package com.example.gccoffee.Service;

import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderItem;
import com.example.gccoffee.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface OrderService {
    public Order order(String email, String address, String postCode, List<OrderItem> orderItems) ;

    public void cancelOrder(UUID o);

    public Order changeOrderStatus(Order order, OrderStatus orderStatus);

    public List<Order> findByEmail(String email);

    public List<Order> findAll();

    public List<Order> findByOrderStatus(OrderStatus orderStatus);

    public List<OrderItem> jsonToOrderItems(Object json);

    public Optional<Order> findById(UUID id);


}

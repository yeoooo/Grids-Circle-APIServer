package com.example.gccoffee.Service;

import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public interface OrderService {
    public Order order(String email, String address, String postCode, UUID productId, int count);

    public void cancelOrder(UUID o);

    public Order updateOrder(Order order);

    public List<Order> findByEmail(String email);



}

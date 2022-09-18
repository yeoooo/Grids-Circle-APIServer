package com.example.gccoffee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class OrderDTO {

    private UUID id;
    private String email;
    private String address;
    private String postcode;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private long price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public OrderDTO(UUID id, String email, String address, String postcode, List<OrderItem> orderItems, OrderStatus orderStatus, long price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }




}

package com.example.gccoffee.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class OrderForm {

    private String email;
    private String address;
    private String postCode;
    private OrderStatus orderStatus = OrderStatus.ACCEPTED;
    private List<OrderItem> orderItems;

}

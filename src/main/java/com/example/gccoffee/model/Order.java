package com.example.gccoffee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Order extends BaseTimeEntity{
    private final UUID orderId;
    private final Email email;
    @Setter
    private  String address;
    @Setter
    private  String postcode;
    private final List<OrderItem> orderItems;
    @Setter
    private  OrderStatus orderStatus;




}

package com.example.gccoffee.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderUpdateForm {
    OrderStatus updateOrderStatus;
    UUID id;
}

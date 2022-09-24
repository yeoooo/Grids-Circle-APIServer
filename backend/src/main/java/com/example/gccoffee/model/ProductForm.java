package com.example.gccoffee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private Long id;
    private String productName;
    private Category category;
    private long price;
    private int quantity;




}


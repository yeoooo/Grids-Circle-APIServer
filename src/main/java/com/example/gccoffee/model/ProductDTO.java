package com.example.gccoffee.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductDTO{
    private String name;
    private String description;
    private long price;
    private int quantity;
    private Category category;

    public ProductDTO(String name, String description, Category category, long price, int quantity) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

}

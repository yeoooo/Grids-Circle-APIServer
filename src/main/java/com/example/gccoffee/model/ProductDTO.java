package com.example.gccoffee.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
public class ProductDTO{
    private String name;
    private String description;
    private long price;
    private int quantity;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO(String name, String description, Category category, long price, int quantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

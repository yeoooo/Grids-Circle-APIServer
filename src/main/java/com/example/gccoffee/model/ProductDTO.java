package com.example.gccoffee.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class ProductDTO{
    private UUID id;
    private String name;
    private String description;
    private long price;
    private int quantity;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ProductDTO(UUID id, String name, String description, Category category, long price, int quantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product toEntity() {
//        return Product.builder()
//                .productId(id)
//                .productName(name)
//                .quantity(quantity)
//                .description(description)
//                .category(category)
//                .price(price)
//                .build();
        return new Product(
                id,
                name,
                category,
                description,
                price,
                quantity
        );
    }

}

package com.example.gccoffee.model;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@Getter
public class Product extends BaseTimeEntity{


    private final UUID productId;
    public Product(UUID productId) {
        this.productId = productId;
    }

    @Setter
    private String productName;

    @Setter
    private Category category;

    @Setter
    private String description;

    public long price;

    @Builder
    public Product(UUID productId, String productName, Category category, String description, long price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
    }

}

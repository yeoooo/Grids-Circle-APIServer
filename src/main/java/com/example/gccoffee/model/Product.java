package com.example.gccoffee.model;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Entity
@NoArgsConstructor
@ToString
@EnableJpaAuditing
public class Product extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private UUID productId;

    @Setter
    private String productName;

    @Setter
    private Category category;

    @Setter
    private String description;

    public long price;

    public int quantity;

    @Builder
    public Product(UUID productId, String productName, Category category, String description, long price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public void addQuantity(int cnt){
        this.quantity += cnt;
    }

    public void removeQuantity(int cnt) {
        this.quantity -= cnt;
    }



}
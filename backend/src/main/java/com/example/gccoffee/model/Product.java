package com.example.gccoffee.model;

import com.example.gccoffee.Exception.NotEnoughStockException;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Entity
@NoArgsConstructor
@ToString
public class Product extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", columnDefinition = "BINARY(16)")
    private UUID productId;

    @Setter
    private String productName;

    @Setter
    private Category category;

    @Setter
    @Column(columnDefinition = "BLOB")
    private String description;

    public long price;

    public int quantity;

   @Builder
    public Product(ProductDTO dto) {
        this.productId = dto.getId();
        this.productName = dto.getName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
        this.category = dto.getCategory();
        this.description = dto.getDescription();
    }

    public Product(UUID productId, String productName, Category category, String description, long price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public void addStock(int cnt){
        this.quantity += cnt;
    }

    public void removeStock(int cnt) {
        int restStock = this.quantity -= cnt;
        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }
        this.quantity = restStock;

    }



}

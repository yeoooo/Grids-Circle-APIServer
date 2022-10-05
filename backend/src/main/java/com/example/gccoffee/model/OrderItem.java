package com.example.gccoffee.model;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private long orderPrice;
    private int count;


    public static OrderItem createOrderItem(Optional<Product> product, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product.get());
        orderItem.setOrderPrice(product.get().getPrice());
        orderItem.setCount(count);
        product.get().removeStock(count);
        return orderItem;
    }

    public void cancel() {
        getProduct().addStock(count);
    }

    public long getTotalPrice() {
        return getOrderPrice() * getCount();
    }





}

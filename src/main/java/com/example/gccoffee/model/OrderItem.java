package com.example.gccoffee.model;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderItem extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private long orderPrice;
    private int count;


    public static OrderItem createOrderItem(Optional<Product> product, long orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product.get());
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        product.get().removeQuantity(count);
        return orderItem;
    }

    public void cancel() {
        getProduct().addQuantity(count);
    }

    public long getTotalPrice() {
        return getOrderPrice() * getCount();
    }





}

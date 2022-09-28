package com.example.gccoffee.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Setter
@Table(name = "orders")//2022-09-7_yeoooo : 테이블 이름이 order인 경우 오류
public class Order extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Email(message = "format must be email")
    private String email;
    @Setter
    private String address;
    @Setter
    private String postcode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Setter
    private OrderStatus orderStatus;


    public static Order createOrder(String email, String address, String postcode, OrderStatus orderStatus, OrderItem... orderItems){
        Order order = new Order();
        order.setEmail(email);
        order.setAddress(address);
        order.setPostcode(postcode);
        order.setOrderStatus(orderStatus);
        for (OrderItem orderItem: orderItems) {
            order.addOrderItem(orderItem);
        }
        return order;
    }

    public void addOrderItem(OrderItem orderItem) {//2022-09-19_yeoooo : Order.addOrderItem을 통해 OrderItem을 넣어주어야 함
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void cancelOrder(){
        if (getOrderStatus() == OrderStatus.SHIPPED) {
            throw new IllegalArgumentException("배송중인 상품은 취소할 수 없습니다.");
        }else{
            this.setOrderStatus(OrderStatus.CANCELLED);
            for (OrderItem orderItem : orderItems) {
                orderItem.cancel();
            }
        }
    }

    public long getTotalPrice() {
        return orderItems.stream().mapToLong(OrderItem::getTotalPrice).sum();
    }

    @Builder
    public Order(OrderDTO dto) {
        this.id = dto.getId();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.postcode = dto.getPostcode();
        this.orderStatus = dto.getOrderStatus();
    }





}

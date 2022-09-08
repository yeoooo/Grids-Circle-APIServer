package com.example.gccoffee.model;

import com.example.gccoffee.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

class OrderTest {
//    @Autowired
//    ProductService productService;
    @Autowired
    OrderService orderService;

    @BeforeEach
    public void setup() {

//        productService.save(p);





    }
    @Test
    @DisplayName("OrderTest")
    public void OrderTest() throws Exception {
        //given
        Product p = new Product();
        p.builder()
                .productId(UUID.randomUUID())
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("this is coffee")
                .price(100)
                .productName("this coffee")
                .build();

        Order o = new Order();
        o.setId(UUID.randomUUID());
        o.setPostcode("zip123");
        o.setEmail("asd@naver.com");
        o.setAddress("here");
        o.setOrderStatus(OrderStatus.ACCEPTED);

        System.out.println("o.toString() = " + o.toString());
//        orderService.order("asd@naver.com", "this coffee", 1, OrderItem);
        //then
//        Assertions.assertThat(orderService.findByEmail("asd@naver.com") instanceof Order);

    }
}
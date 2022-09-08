package com.example.gccoffee.Service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@EnableJpaAuditing
class OrderServiceImplTest {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @Test
    @DisplayName("주문 테스트")
    @Transactional
    @Rollback(value = false)
    public void orderTest() throws Exception {
        //given

        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        //when
        productService.save(p);


//        Order o = new Order();
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 2);
//        System.out.println("p.getProductId().toString() = " + p.getProductId().toString());
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 1);
//        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
        //when

        //then

    }
 @Test
    @DisplayName("재고 테스트")
    @Transactional
    @Rollback(value = false)
    public void stockTest() throws Exception {
        //given

        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        //when
        productService.save(p);


//        Order o = new Order();
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 3);
//        System.out.println("p.getProductId().toString() = " + p.getProductId().toString());
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
        //when

        //then

    }

}
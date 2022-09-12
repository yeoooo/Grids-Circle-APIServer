package com.example.gccoffee.Service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.Assertions;
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


        //when

        //then
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 3);
         orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
         orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
     }, "재고보다 많은 주문은 예외를 일으킨다");

    }
    @Test
    @DisplayName("가격 테스트")
    @Transactional
    @Rollback(value = false)
    public void totalPriceTest() throws Exception {
        //given

        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(100)
                .build();
        //when
        productService.save(p);

        //when
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
        orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);

//        then
        Assertions.assertEquals( 1000,orderService.findByEmail("asd@naver.com").get(0).getTotalPrice()
                , "100원짜리 5개의 상품을 주문한 주문서의 총 가격은 1천원이다");
    }
    @Test
    @DisplayName("주문 취소 테스트")
    @Transactional
    @Rollback(value = false)
    public void orderCancelTest() throws Exception {
        //given

        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(100)
                .build();
        productService.save(p);

        Order o = orderService.order("asd@naver.com", "here", "zip123", p.getProductId(), 5);
        //when
        orderService.cancelOrder(o.getId());
        productService.findById(p.getProductId()).get().getQuantity();

        //then
        Assertions.assertEquals(orderService.findByEmail("asd@naver.com").get(0).getOrderStatus(), OrderStatus.CANCELLED, "주문 상태는 취소로 바뀌어 있어야한다.");
    }
}
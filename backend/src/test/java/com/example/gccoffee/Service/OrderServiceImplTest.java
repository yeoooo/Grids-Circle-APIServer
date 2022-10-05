package com.example.gccoffee.Service;

import com.example.gccoffee.Exception.NotEnoughStockException;
import com.example.gccoffee.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @Test
    @DisplayName("주문 테스트")
    @Transactional
    public void orderTest() throws Exception {
        //given
        UUID id = UUID.randomUUID();
        Product p = Product
                .builder()
                .dto(ProductDTO.builder()
                        .id(id)
                        .name("CoffeeJoa")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        List<OrderItem> o = new ArrayList<>();


        //when
        o.add(OrderItem.createOrderItem(productService.findByName("커피짱2"), 1));
        orderService.order("asd@naver.com", "here", "zip123", o);

        //then
        org.assertj.core.api.Assertions.assertThat(!orderService.findAll().isEmpty());

    }
    @Test
    @DisplayName("재고 테스트")
    @Transactional
    public void stockTest() throws Exception {
        //given
        Optional<Product> p = productService.findByName("커피짱2");
        List<OrderItem> o = new ArrayList<>();
        //when
        //then
     assertThrows(Exception.class, () -> {
        o.add(OrderItem.createOrderItem(p, 10));
         orderService.order("asd@naver.com", "here", "zip123", o);
     }, "재고보다 많은 주문은 예외를 일으켜야 한다.");
    }

    @Test
    @DisplayName("주문 일괄 처리 테스트")
    @Transactional
    public void batchProcessing() throws Exception {
        //given
        Optional<Product> p = productService.findByName("커피짱2");
        List<OrderItem> o = new ArrayList<>();
        //when
        o.add(OrderItem.createOrderItem(p, 1));
        orderService.order("asd@naver.com", "here", "zip123", o);
        orderService.order("asd@naver.com", "here", "zip123", o);
        orderService.order("asd@naver.com", "here", "zip123", o);
        //then
        org.assertj.core.api.Assertions.assertThat(orderService.findAll().size()).isEqualTo(1);
        //2022-10-5_yeoooo : 여러번 일어난 주문이 작일 2시와 당일 2시에 일어났다면 하나의 주문서로 처리해야 한다.
    }
    @Test
    @DisplayName("가격 테스트")
    @Transactional
    @Rollback(value = false)
    public void totalPriceTest() throws Exception {
        //given

        Optional<Product> p = productService.findByName("커피짱2");

        List<OrderItem> o = new ArrayList<>();
        //when
        o.add(OrderItem.createOrderItem(p, 5));

        Order order = orderService.order("asd@naver.com", "here", "zip123", o);
        orderService.order("asd@naver.com", "here", "zip123", o);

//        then
        assertEquals( 1000,orderService.findByEmail("asd@naver.com").get(0).getTotalPrice()
                , "100원짜리 5개의 상품을 주문한 주문서 2개의 총 가격은 1000원이다");
    }
    @Test
    @DisplayName("주문 취소 테스트")
    @Transactional
    public void orderCancelTest() throws Exception {
        //given
        Optional<Product> p = productService.findByName("커피짱2");
        List<OrderItem> o = new ArrayList<>();
        o.add(OrderItem.createOrderItem(p, 5));
        Order order = orderService.order("asd@naver.com", "here", "zip123", o);
        //when
        order.cancelOrder();
        //then
        assertEquals(orderService.findByEmail("asd@naver.com").get(0).getOrderStatus(), OrderStatus.CANCELLED, "주문 상태는 취소로 바뀌어 있어야한다.");
    }
}
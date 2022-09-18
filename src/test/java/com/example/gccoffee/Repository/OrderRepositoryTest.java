package com.example.gccoffee.Repository;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;



    @BeforeEach
    @Test
    public void setUp() throws Exception {
        //given
        //given
        Product p = new Product();
//        p.builder()
//                .productId(UUID.randomUUID())
//                .category(Category.COFFEE_BEAN_PACKAGE)
//                .description("this is coffee")
//                .price(100)
//                .productName("this coffee")
//                .build();

        Order o = new Order();
        o.setId(UUID.randomUUID());
        o.setPostcode("zip123");
        o.setEmail("asd@naver.com");
        o.setAddress("here");
        o.setOrderStatus(OrderStatus.ACCEPTED);
//        o.setCreatedAt(LocalDateTime.now().withDayOfMonth(8));
//        orderService.order(o);

        Order o1 = new Order();
        o1.setId(UUID.randomUUID());
        o1.setPostcode("zip123");
        o1.setEmail("asd@naver.com");
        o1.setAddress("here");
        o1.setOrderStatus(OrderStatus.ACCEPTED);
//        o1.setCreatedAt(LocalDateTime.now().withDayOfMonth(9));
//        orderService.order(o1);

        Order o2 = new Order();
        o2.setId(UUID.randomUUID());
        o2.setPostcode("zip123");
        o2.setEmail("asd@naver.com");
        o2.setAddress("here");
        o2.setOrderStatus(OrderStatus.ACCEPTED);
//        o2.setCreatedAt(LocalDateTime.now().withDayOfMonth(10).withHour(15));
//        orderService.order(o2);


        System.out.println("o.toString() = " + o.toString());
        //when

        //then
    }

    @Test
    @Transactional
    public void timeTest() throws Exception {
        //given
        Optional<Order> o = orderRepository.findByEmailAndDayOrder("asd@naver.com", LocalDateTime.now());
        //when
        System.out.println("orders = " + o);
        //then

    }
}
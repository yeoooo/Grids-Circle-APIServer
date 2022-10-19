package com.example.gccoffee.Service;

import com.example.gccoffee.model.*;
import com.example.gccoffee.model.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    public static UUID productId;

    @Transactional
    @BeforeEach
    public void setUp() {

        Product p = Product
                .builder()
                .dto(ProductDTO.builder()
//                        .id(productId)
                        //2022-10-8_yeoooo : generated 될 field가 입력되면 save되지 않는다. 꼭 참고
                        .name("테스트콩")
                        .price(1000)
                        .category(Category.BEAN)
                        .quantity(15)
                        .description("테스트용")
                        .build())
                .build();

        productId = productService.save(p);

        p = productService.findById(productId).get();


    }

    @Test
    @DisplayName("주문 테스트")
    @Transactional
    public void orderTest() throws Exception {
        //given
        List<OrderItem> o = new ArrayList<>();
        o.add(OrderItem.createOrderItem(productService.findByName("테스트콩1"), 1));
        //when

        OrderDTO newOrderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();
        orderService.order(newOrderDTO);

        //then
        org.assertj.core.api.Assertions.assertThat(!orderService.findAll().isEmpty());



    }
    @Test
    @DisplayName("재고 테스트")
    @Transactional
    public void stockTest() throws Exception {
        //given
        Optional<Product> p = productService.findByName("테스트콩1");
        List<OrderItem> o = new ArrayList<>();
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();

        //when
        //then
     assertThrows(Exception.class, () -> {
         o.add(OrderItem.createOrderItem(p, 10));
         orderService.order(newOrderDTO);
     }, "재고보다 많은 주문은 예외를 일으켜야 한다.");
    }

    @Test
    @DisplayName("주문 일괄 처리 테스트")
    @Transactional
    public void batchProcessing() throws Exception {
        //given
        Optional<Product> p = productService.findByName("테스트콩1");
        List<OrderItem> o = new ArrayList<>();
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();
        //when
        o.add(OrderItem.createOrderItem(p, 1));
        orderService.order(newOrderDTO);
        orderService.order(newOrderDTO);
        orderService.order(newOrderDTO);
        //then
        org.assertj.core.api.Assertions.assertThat(orderService.findAll().size()).isEqualTo(1);
        //2022-10-5_yeoooo : 여러번 일어난 주문이 작일 2시와 당일 2시에 일어났다면 하나의 주문서로 처리해야 한다.
    }
    @Test
    @DisplayName("가격 테스트")
    @Transactional
    public void totalPriceTest() throws Exception {
        //given

        Optional<Product> p = productService.findByName("테스트콩1");

        List<OrderItem> o = new ArrayList<>();
        //when
        o.add(OrderItem.createOrderItem(p, 5));
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();

        UUID id = orderService.order(newOrderDTO);
        orderService.order(newOrderDTO);

//        then
        assertEquals( 1000,orderService.findById(id).get().getTotalPrice()
                , "100원짜리 5개의 상품을 주문한 주문서 2개의 총 가격은 1000원이다");
    }
    @Test
    @DisplayName("주문 취소 테스트")
    @Transactional
    public void orderCancelTest() throws Exception {
        //given
        Optional<Product> p = productService.findByName("테스트콩1");
        List<OrderItem> o = new ArrayList<>();
        o.add(OrderItem.createOrderItem(p, 1));
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();
        UUID id = orderService.order(newOrderDTO);
        Optional<Order> targetOrder = orderService.findById(id);
        //when
        targetOrder.get().cancelOrder();
        //then
        assertEquals(targetOrder.get().getOrderStatus(), OrderStatus.CANCELLED, "주문 상태는 취소로 바뀌어 있어야한다.");
    }
}
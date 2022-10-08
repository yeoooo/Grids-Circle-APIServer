package com.example.gccoffee.Controller;

import com.example.gccoffee.Repository.OrderRepository;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import com.example.gccoffee.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class OrderRestControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    MockMvc mockMvc;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ObjectMapper objectMapper;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    static UUID productId;
    static UUID orderId;


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
        List<OrderItem> o = new ArrayList<>();
        o.add(OrderItem.createOrderItem(Optional.of(p), 1));
        OrderDTO orderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(o)
                .build();
        orderId = orderService.order(orderDTO);
    }

    @AfterEach
    @Transactional
    public void tearDown() {
        productRepository.deleteAll();
        orderRepository.deleteAll();
    }


    @Test
    @DisplayName("주문 테스트")
    @Transactional
    public void orderTest() throws Exception {

        Optional<Order> order = orderService.findById(orderId);

        String req = objectMapper.writeValueAsString(order.get());

        System.out.println("req = " + req);
        this.mockMvc.perform(post("/api/v1/orders")
                        .content(req)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("order-post",
                        requestFields(
                                List.of(
                            fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                            fieldWithPath("address").type(JsonFieldType.STRING).description("주소"),
                            fieldWithPath("postcode").type(JsonFieldType.STRING).description("우편번호"),
                            fieldWithPath("OrderItems").type(JsonFieldType.ARRAY).description("주문상품")
//                            fieldWithPath("product").type(JsonFieldType.ARRAY).description("상품"),
//                            fieldWithPath("productName").type(JsonFieldType.ARRAY).description("주문상품")
//                            fieldWithPath("cate").type(JsonFieldType.ARRAY).description("주문상품"),
//                            fieldWithPath("OrderItems").type(JsonFieldType.ARRAY).description("주문상품"),
//                            fieldWithPath("OrderItems").type(JsonFieldType.ARRAY).description("주문상품"),
//                            fieldWithPath("OrderItems").type(JsonFieldType.ARRAY).description("주문상품"),
//                            fieldWithPath("OrderItems").type(JsonFieldType.ARRAY).description("주문상품")
                                )
                        ),
                        responseFields(
                            fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("상태코드"),
                            fieldWithPath("data").type(JsonFieldType.OBJECT).description("데이터"),
                            fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("응답시간")
                        )
                        )
                );
    }
}

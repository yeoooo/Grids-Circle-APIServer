package com.example.gccoffee.Controller;

import com.example.gccoffee.Repository.OrderRepository;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@DirtiesContext
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
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

    private ManualRestDocumentation restDocumentation = new ManualRestDocumentation();

    static UUID productId;
    static UUID orderId;


    @Transactional
    @BeforeEach
    @Rollback(value = false)
    public void setUp() {
        Product p = Product
                .builder()
                .dto(ProductDTO.builder()
//                        .id(productId)
                        //2022-10-8_yeoooo : generated ??? field??? ???????????? save?????? ?????????. ??? ??????
                        .name("????????????")
                        .price(1000)
                        .category(Category.BEAN)
                        .quantity(15)
                        .description("????????????")
                        .build())
                .build();

        productId = productService.save(p);

        p = productService.findById(productId).get();
    }

    @AfterEach
    @Transactional
    public void tearDown() {
        this.restDocumentation.afterTest();
        productService.truncateRepo();

    }


    @Test
    @DisplayName("?????? API ?????????")
    @Transactional
    public void orderTest() throws Exception {
        Product p = productService.findById(productId).get();
        OrderDTO orderDTO = OrderDTO.builder()
                .email("email@naver.com")
                .address("address")
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode("postcode")
                .orderItems(List.of(OrderItem.createOrderItem(Optional.of(p), 1)))
                .build();

        String req = objectMapper.writeValueAsString(orderDTO);

        this.mockMvc.perform(post("/api/v1/orders")
                        .content(req)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("order-post",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                            List.of(
                            fieldWithPath("email").type(JsonFieldType.STRING).description("?????????"),
                            fieldWithPath("id").type(JsonFieldType.NULL).description("???????????????").ignored(),
                            fieldWithPath("address").type(JsonFieldType.STRING).description("??????"),
                            fieldWithPath("postcode").type(JsonFieldType.STRING).description("????????????"),
                            fieldWithPath("createdAt").type(JsonFieldType.NULL).description("???????????????").ignored(),
                            fieldWithPath("updatedAt").type(JsonFieldType.NULL).description("???????????????").ignored(),
                            fieldWithPath("orderStatus").type(JsonFieldType.STRING).description("????????????"),
                            fieldWithPath("price").type(JsonFieldType.NUMBER).description("???????????????").ignored(),
                            fieldWithPath("orderItems[]").type(JsonFieldType.ARRAY).description("????????????"),
                            fieldWithPath("orderItems[].id").type(JsonFieldType.NULL).description("?????????????????????").ignored(),
                            fieldWithPath("orderItems[].order").type(JsonFieldType.NULL).description("????????????").ignored(),
                            fieldWithPath("orderItems[].orderPrice").type(JsonFieldType.NUMBER).description("????????????").ignored(),
                            fieldWithPath("orderItems[].count").type(JsonFieldType.NUMBER).description("??????????????????").ignored(),
                            fieldWithPath("orderItems[].totalPrice").type(JsonFieldType.NUMBER).description("???????????? ??? ??????").ignored(),
                            fieldWithPath("orderItems[].createdAt").type(JsonFieldType.NULL).ignored(),
                            fieldWithPath("orderItems[].updatedAt").type(JsonFieldType.NULL).ignored(),
                            fieldWithPath("orderItems[].product").type(JsonFieldType.OBJECT).description("??????"),
                            fieldWithPath("orderItems[].product.productName").type(JsonFieldType.STRING).description("?????????"),
                            fieldWithPath("orderItems[].product.productId").type(JsonFieldType.STRING).description("???????????????").ignored(),
                            fieldWithPath("orderItems[].product.category").type(JsonFieldType.STRING).description("?????? ????????????").ignored(),
                            fieldWithPath("orderItems[].product.description").type(JsonFieldType.STRING).description("?????? ??????").ignored(),
                            fieldWithPath("orderItems[].product.price").type(JsonFieldType.NUMBER).description("?????? ??????").ignored(),
                            fieldWithPath("orderItems[].product.quantity").type(JsonFieldType.NUMBER).description("?????? ??????").ignored(),
                            fieldWithPath("orderItems[].product.createdAt").type(JsonFieldType.STRING).description("?????? ?????????").ignored(),
                            fieldWithPath("orderItems[].product.updatedAt").type(JsonFieldType.STRING).description("?????? ?????????").ignored()
                            )
                        ),
                        responseFields(
                            fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("????????????"),
                            fieldWithPath("data").type(JsonFieldType.OBJECT).description("?????????"),
                            fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("????????????"),
                                fieldWithPath("data.email").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("data.id").type(JsonFieldType.NULL).description("???????????????").ignored(),
                                fieldWithPath("data.address").type(JsonFieldType.STRING).description("??????"),
                                fieldWithPath("data.postcode").type(JsonFieldType.STRING).description("????????????"),
                                fieldWithPath("data.createdAt").type(JsonFieldType.NULL).description("?????????").ignored(),
                                fieldWithPath("data.updatedAt").type(JsonFieldType.NULL).description("???????????????").ignored(),
                                fieldWithPath("data.orderStatus").type(JsonFieldType.STRING).description("????????????"),
                                fieldWithPath("data.price").type(JsonFieldType.NUMBER).description("??????"),
                                fieldWithPath("data.orderItems").type(JsonFieldType.ARRAY).description("????????????"),
                                fieldWithPath("data.orderItems[].id").type(JsonFieldType.STRING).description("?????????????????????").ignored(),
                                fieldWithPath("data.orderItems[].order").type(JsonFieldType.OBJECT).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.createdAt").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.updatedAt").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.id").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.email").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.address").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.postcode").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.orderStatus").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].order.totalPrice").type(JsonFieldType.NUMBER).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].orderPrice").type(JsonFieldType.NUMBER).description("?????????????????????"),
                                fieldWithPath("data.orderItems[].count").type(JsonFieldType.NUMBER).description("??????????????????"),
                                fieldWithPath("data.orderItems[].totalPrice").type(JsonFieldType.NUMBER).description("??????").ignored(),
                                fieldWithPath("data.orderItems[].createdAt").type(JsonFieldType.STRING).description("?????????????????????").ignored(),
                                fieldWithPath("data.orderItems[].updatedAt").type(JsonFieldType.STRING).description("?????????????????????").ignored(),
                                fieldWithPath("data.orderItems[].product").type(JsonFieldType.OBJECT).description("??????"),
                                fieldWithPath("data.orderItems[].product.productName").type(JsonFieldType.STRING).description("????????????"),
                                fieldWithPath("data.orderItems[].product.productId").type(JsonFieldType.STRING).description("???????????????").ignored(),
                                fieldWithPath("data.orderItems[].product.category").type(JsonFieldType.STRING).description("??????????????????"),
                                fieldWithPath("data.orderItems[].product.description").type(JsonFieldType.STRING).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].product.price").type(JsonFieldType.NUMBER).description("????????????"),
                                fieldWithPath("data.orderItems[].product.quantity").type(JsonFieldType.NUMBER).description("????????????").ignored(),
                                fieldWithPath("data.orderItems[].product.createdAt").type(JsonFieldType.STRING).description("???????????????").ignored(),
                                fieldWithPath("data.orderItems[].product.updatedAt").type(JsonFieldType.STRING).description("???????????????").ignored()
                        )
                        )
                );
    }
}

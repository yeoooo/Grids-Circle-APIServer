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

    @AfterEach
    @Transactional
    public void tearDown() {
        this.restDocumentation.afterTest();
        productService.truncateRepo();

    }


    @Test
    @DisplayName("주문 API 테스트")
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
                            fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                            fieldWithPath("id").type(JsonFieldType.NULL).description("주문식별자").ignored(),
                            fieldWithPath("address").type(JsonFieldType.STRING).description("주소"),
                            fieldWithPath("postcode").type(JsonFieldType.STRING).description("우편번호"),
                            fieldWithPath("createdAt").type(JsonFieldType.NULL).description("주문등록일").ignored(),
                            fieldWithPath("updatedAt").type(JsonFieldType.NULL).description("주문수정일").ignored(),
                            fieldWithPath("orderStatus").type(JsonFieldType.STRING).description("주문상태"),
                            fieldWithPath("price").type(JsonFieldType.NUMBER).description("주문수정일").ignored(),
                            fieldWithPath("orderItems[]").type(JsonFieldType.ARRAY).description("주문상품"),
                            fieldWithPath("orderItems[].id").type(JsonFieldType.NULL).description("주문상품식별자").ignored(),
                            fieldWithPath("orderItems[].order").type(JsonFieldType.NULL).description("관련주문").ignored(),
                            fieldWithPath("orderItems[].orderPrice").type(JsonFieldType.NUMBER).description("주문상품").ignored(),
                            fieldWithPath("orderItems[].count").type(JsonFieldType.NUMBER).description("주문상품개수").ignored(),
                            fieldWithPath("orderItems[].totalPrice").type(JsonFieldType.NUMBER).description("주문상품 당 총액").ignored(),
                            fieldWithPath("orderItems[].createdAt").type(JsonFieldType.NULL).ignored(),
                            fieldWithPath("orderItems[].updatedAt").type(JsonFieldType.NULL).ignored(),
                            fieldWithPath("orderItems[].product").type(JsonFieldType.OBJECT).description("상품"),
                            fieldWithPath("orderItems[].product.productName").type(JsonFieldType.STRING).description("상품명"),
                            fieldWithPath("orderItems[].product.productId").type(JsonFieldType.STRING).description("상품식별자").ignored(),
                            fieldWithPath("orderItems[].product.category").type(JsonFieldType.STRING).description("상품 카테고리").ignored(),
                            fieldWithPath("orderItems[].product.description").type(JsonFieldType.STRING).description("상품 설명").ignored(),
                            fieldWithPath("orderItems[].product.price").type(JsonFieldType.NUMBER).description("상품 가격").ignored(),
                            fieldWithPath("orderItems[].product.quantity").type(JsonFieldType.NUMBER).description("상품 재고").ignored(),
                            fieldWithPath("orderItems[].product.createdAt").type(JsonFieldType.STRING).description("상품 등록일").ignored(),
                            fieldWithPath("orderItems[].product.updatedAt").type(JsonFieldType.STRING).description("상품 수정일").ignored()
                            )
                        ),
                        responseFields(
                            fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("상태코드"),
                            fieldWithPath("data").type(JsonFieldType.OBJECT).description("데이터"),
                            fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("응답시간"),
                                fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("data.id").type(JsonFieldType.NULL).description("주문식별자").ignored(),
                                fieldWithPath("data.address").type(JsonFieldType.STRING).description("주소"),
                                fieldWithPath("data.postcode").type(JsonFieldType.STRING).description("우편번호"),
                                fieldWithPath("data.createdAt").type(JsonFieldType.NULL).description("주문일").ignored(),
                                fieldWithPath("data.updatedAt").type(JsonFieldType.NULL).description("주문수정일").ignored(),
                                fieldWithPath("data.orderStatus").type(JsonFieldType.STRING).description("주문상태"),
                                fieldWithPath("data.price").type(JsonFieldType.NUMBER).description("총액"),
                                fieldWithPath("data.orderItems").type(JsonFieldType.ARRAY).description("주문상품"),
                                fieldWithPath("data.orderItems[].id").type(JsonFieldType.STRING).description("주문상품식별자").ignored(),
                                fieldWithPath("data.orderItems[].order").type(JsonFieldType.OBJECT).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.createdAt").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.updatedAt").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.id").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.email").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.address").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.postcode").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.orderStatus").type(JsonFieldType.STRING).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].order.totalPrice").type(JsonFieldType.NUMBER).description("주문상품").ignored(),
                                fieldWithPath("data.orderItems[].orderPrice").type(JsonFieldType.NUMBER).description("주문상품단일가"),
                                fieldWithPath("data.orderItems[].count").type(JsonFieldType.NUMBER).description("주문상품개수"),
                                fieldWithPath("data.orderItems[].totalPrice").type(JsonFieldType.NUMBER).description("총액").ignored(),
                                fieldWithPath("data.orderItems[].createdAt").type(JsonFieldType.STRING).description("주문상품등록일").ignored(),
                                fieldWithPath("data.orderItems[].updatedAt").type(JsonFieldType.STRING).description("주문상품수정일").ignored(),
                                fieldWithPath("data.orderItems[].product").type(JsonFieldType.OBJECT).description("상품"),
                                fieldWithPath("data.orderItems[].product.productName").type(JsonFieldType.STRING).description("상품이름"),
                                fieldWithPath("data.orderItems[].product.productId").type(JsonFieldType.STRING).description("상품식별자").ignored(),
                                fieldWithPath("data.orderItems[].product.category").type(JsonFieldType.STRING).description("상품카테고리"),
                                fieldWithPath("data.orderItems[].product.description").type(JsonFieldType.STRING).description("상품설명").ignored(),
                                fieldWithPath("data.orderItems[].product.price").type(JsonFieldType.NUMBER).description("상품가격"),
                                fieldWithPath("data.orderItems[].product.quantity").type(JsonFieldType.NUMBER).description("상품재고").ignored(),
                                fieldWithPath("data.orderItems[].product.createdAt").type(JsonFieldType.STRING).description("상품등록일").ignored(),
                                fieldWithPath("data.orderItems[].product.updatedAt").type(JsonFieldType.STRING).description("상품수정일").ignored()
                        )
                        )
                );
    }
}

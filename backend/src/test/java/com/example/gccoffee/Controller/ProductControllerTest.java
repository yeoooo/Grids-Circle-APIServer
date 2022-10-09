package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class ProductControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ProductService productService;

    private ManualRestDocumentation restDocumentation = new ManualRestDocumentation();
    @AfterEach
    @Transactional
    public void tearDown() {
        this.restDocumentation.afterTest();
    }
    
    @Test
    @DisplayName("전체상품조회")
    public void findAllProduct() throws Exception {
        this.mockMvc.perform(get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("product-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                                responseFields(
                                        List.of(
                                                fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("상태코드"),
                                                fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("응답시간"),
                                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("데이터"),
                                                fieldWithPath("data[].productId").type(JsonFieldType.STRING).description("상품식별자"),
                                                fieldWithPath("data[].productName").type(JsonFieldType.STRING).description("상품명"),
                                                fieldWithPath("data[].category").type(JsonFieldType.STRING).description("카테고리"),
                                                fieldWithPath("data[].description").type(JsonFieldType.STRING).description("상품설명"),
                                                fieldWithPath("data[].price").type(JsonFieldType.NUMBER).description("가격"),
                                                fieldWithPath("data[].quantity").type(JsonFieldType.NUMBER).description("재고"),
                                                fieldWithPath("data[].createdAt").type(JsonFieldType.STRING).description("상품등록일"),
                                                fieldWithPath("data[].updatedAt").type(JsonFieldType.STRING).description("상품수정일")
                                        )

                                )

                        )
                );
    }
    @Test
    @DisplayName("카테고리 조회 테스트")
    public void findCategories() throws Exception {
        this.mockMvc.perform(get("/api/v1/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("category-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                                responseFields(
                                        List.of(
                                        fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("상태코드"),
                                        fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("응답시간"),
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("카테고리")
                                        )

                                )

                        )
                );
    }
}

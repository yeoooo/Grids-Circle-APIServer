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
import org.springframework.test.annotation.DirtiesContext;
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
@DirtiesContext
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
    @DisplayName("??????????????????")
    public void findAllProduct() throws Exception {
        this.mockMvc.perform(get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("product-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                                responseFields(
                                        List.of(
                                                fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("????????????"),
                                                fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("????????????"),
                                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("?????????"),
                                                fieldWithPath("data[].productId").type(JsonFieldType.STRING).description("???????????????"),
                                                fieldWithPath("data[].productName").type(JsonFieldType.STRING).description("?????????"),
                                                fieldWithPath("data[].category").type(JsonFieldType.STRING).description("????????????"),
                                                fieldWithPath("data[].description").type(JsonFieldType.STRING).description("????????????"),
                                                fieldWithPath("data[].price").type(JsonFieldType.NUMBER).description("??????"),
                                                fieldWithPath("data[].quantity").type(JsonFieldType.NUMBER).description("??????"),
                                                fieldWithPath("data[].createdAt").type(JsonFieldType.STRING).description("???????????????"),
                                                fieldWithPath("data[].updatedAt").type(JsonFieldType.STRING).description("???????????????")
                                        )

                                )

                        )
                );
    }
    @Test
    @DisplayName("???????????? ?????? ?????????")
    public void findCategories() throws Exception {
        this.mockMvc.perform(get("/api/v1/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("category-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                                responseFields(
                                        List.of(
                                        fieldWithPath("statusCode").type(JsonFieldType.NUMBER).description("????????????"),
                                        fieldWithPath("serverDatetime").type(JsonFieldType.STRING).description("????????????"),
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("????????????")
                                        )

                                )

                        )
                );
    }
}

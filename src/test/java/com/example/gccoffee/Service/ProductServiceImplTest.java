package com.example.gccoffee.Service;

import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@EnableJpaAuditing
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("상품 생성 테스트")
    @Transactional
    @Rollback(value = false)
    public void createProduct() throws Exception {
        //given
//        Product p = new Product();
//        p.setProductName("CoffeeJoa");
//        p.setCategory(Category.COFFEE_BEAN_PACKAGE);
        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        //when
        productService.save(p);
        //then
        productService.findById(p.getProductId());

    }

}
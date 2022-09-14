package com.example.gccoffee.Service;

import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@EnableJpaAuditing

class ProductServiceImplTest {

    Logger log = LoggerFactory.getLogger(getClass());

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

    @Test
    public void productDeleteTest() throws Exception {
        //given
        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        productService.save(p);
        //when
        productService.delete(p.getProductId());
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            productService.findById(p.getProductId());
        });

    }

    @Test
    @DisplayName("상품 업데이트 테스트")
    @Transactional
    @Rollback(value = false)
    public void productUpdateTest() throws Exception {
        //given
        Product p = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        productService.save(p);
        log.info("found Product : {}", productService.findById(p.getProductId()).get().toString());
        //when
        productService.update(p, "CoffeeNotJoa", Category.COFFEE_BEAN_PACKAGE, "커피안조아");
        //then
        log.info("updated Product : {}", productService.findById(p.getProductId()).get().toString());

        Assertions.assertEquals("커피안조아", productService.findById(p.getProductId()).get().getDescription());
        Assertions.assertEquals("CoffeeNotJoa", productService.findById(p.getProductId()).get().getProductName());
    }
    
    @Test
    @DisplayName("카테고리 검색 테스트")
    @Rollback(value = false)
    public void categorySearchTest() throws Exception {
        //given

        Product coffeeBean = Product.builder()
                .productName("CoffeeJoa")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
       Product coffeeBean1 = Product.builder()
                .productName("CoffeeJoa1")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .description("커피 조아?")
                .price(100)
                .quantity(3)
                .build();
        Product coffeeCup = Product.builder()
                .productName("JoaCup")
                .category(Category.COFFEE_CUP)
                .description("조아 컵!")
                .price(200)
                .quantity(5)
                .build();
        Product coffeeCup1 = Product.builder()
                .productName("JoaCup1")
                .category(Category.COFFEE_CUP)
                .description("조아 컵!")
                .price(200)
                .quantity(5)
                .build();
        productService.save(coffeeBean);
        productService.save(coffeeBean1);
        productService.save(coffeeCup);
        productService.save(coffeeCup1);

        //when
        List<Product> foundBean = productService.findByCategory(Category.COFFEE_BEAN_PACKAGE);
        List<Product> foundCup = productService.findByCategory(Category.COFFEE_CUP);
        //then
        for (Product p :
                foundBean) {
            log.info("found bean => {}", p);
        }

        for (Product p :
                foundCup) {
            log.info("found cup => {}", p);
        }
        org.assertj.core.api.Assertions.assertThat(foundBean.size() != 0);
        org.assertj.core.api.Assertions.assertThat(foundCup.size() != 0);


    }

}
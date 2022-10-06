package com.example.gccoffee.Service;

import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("상품 생성 테스트")
    @Transactional
    public void createProduct() throws Exception {
        //given
        Product p = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeJoa")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();

        //when
        productService.save(p);
        //then
        productService.findById(p.getProductId());
    }

    @Test
    @Transactional
    @Rollback
    public void productDeleteTest() throws Exception {
        Product p = productService.findByName("커피짱2").get();
        System.out.println("p = " + p);
        //when
        productService.delete(p.getProductId());
        //then
        org.assertj.core.api.Assertions.assertThat(productService.findByName("커피짱2").isEmpty());
    }

    @Test
    @DisplayName("상품 업데이트 테스트")
    public void productUpdateTest() throws Exception {
        //given
        Product p = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeJoa")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        productService.save(p);
        log.info("found Product : {}", productService.findById(p.getProductId()).get().toString());
        //when
        productService.update(p, "CoffeeNotJoa", 10L,10,"커피안조아");
        //then
        log.info("updated Product : {}", productService.findById(p.getProductId()).get().toString());

        Assertions.assertEquals("커피안조아", productService.findById(p.getProductId()).get().getDescription());
        Assertions.assertEquals("CoffeeNotJoa", productService.findById(p.getProductId()).get().getProductName());
    }
//
    @Test
    @DisplayName("카테고리 검색 테스트")
    @Rollback(value = false)
    @Disabled
    public void categorySearchTest() throws Exception {
        //given

        Product coffeeBean = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeJoa")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        Product coffeeBean1 = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeJoa")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        Product coffeeCup = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeCup1")
                        .category(Category.BEAN)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        Product coffeeCup1 = Product
                .builder()
                .dto(ProductDTO.builder()
                        .name("CoffeeCu2")
                        .category(Category.CUP)
                        .price(100)
                        .quantity(100)
                        .build())
                .build();
        productService.save(coffeeBean);
        productService.save(coffeeBean1);
        productService.save(coffeeCup);
        productService.save(coffeeCup1);

        //when
        List<Product> foundBean = productService.findByCategory(Category.BEAN);
        List<Product> foundCup = productService.findByCategory(Category.CUP);
        //then
        for (Product p :
                foundBean) {
//            log.info("found bean => {}", p);
        }

        for (Product p :
                foundCup) {
//            log.info("found cup => {}", p);
        }
        org.assertj.core.api.Assertions.assertThat(foundBean.size() != 0);
        org.assertj.core.api.Assertions.assertThat(foundCup.size() != 0);


    }

}
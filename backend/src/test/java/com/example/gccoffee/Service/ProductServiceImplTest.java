package com.example.gccoffee.Service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Slf4j
@DirtiesContext
class ProductServiceImplTest {

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
    @DisplayName("상품 생성 테스트")
    @Transactional
    public void createProduct() throws Exception {
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
    @Transactional
    public void productDeleteTest() throws Exception {
        Optional<Product> p = productService.findById(productId);
        //when
        productService.delete(p.get().getProductId());
        //then
        org.assertj.core.api.Assertions.assertThat(p.isEmpty());
    }

    @Test
    @DisplayName("상품 업데이트 테스트")
    public void productUpdateTest() throws Exception {
        //given
        Optional<Product> p = productService.findById(productId);
        //when
        productService.update(p.get(), "테스트콩2", 10L,10,"테스트용2");
        //then
        Assertions.assertEquals("테스트용2", productService.findById(productId).get().getDescription());
        Assertions.assertEquals("테스트콩2", productService.findById(productId).get().getProductName());
    }
//
    @Test
    @DisplayName("카테고리 검색 테스트")
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
        }

        for (Product p :
                foundCup) {
        }
        org.assertj.core.api.Assertions.assertThat(foundBean.size() != 0);
        org.assertj.core.api.Assertions.assertThat(foundCup.size() != 0);
    }

}
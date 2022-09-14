package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@EnableJpaAuditing
public class ProductController extends BaseTimeEntity {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/management")
    public String getProductList(Model model) {
        Category[] categories = Category.values();
        HashMap<Category,List> map = new HashMap<>();
        for (Category c : categories) {//2022-09-14_yeoooo : 카테고리 이름 : 카테고리에 해당하는 제품
            map.put(c, productService.findByCategory(c).stream().map(
                    product -> new ProductDTO(product.getProductName(),
                            product.getDescription(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getQuantity(),
                            product.getCreatedAt(),
                            product.getUpdatedAt())
            ).collect(Collectors.toList()));
        }
        log.info("map completed : {}", map);
        model.addAttribute("products", map);
//        model.addAttribute("categories", categories);
        model.addAttribute("productForm", new ProductForm());

        return "management";
    }
// @GetMapping("/management")
//    public String getProductList(Model model) {
//        Category[] categories = Category.values();
//
//        HashMap<ProductDTO,Category> map = new HashMap<>();
//        for (Category c : categories) {
//            List<ProductDTO> products = productService.findByCategory(c).stream().map(
//                    product -> new ProductDTO(product.getProductName(),
//                            product.getDescription(),
//                            product.getCategory(),
//                            product.getPrice(),
//                            product.getQuantity(),
//                            product.getCreatedAt(),
//                            product.getUpdatedAt())
//            ).collect(Collectors.toList());
//
//            for (ProductDTO p : products) {
//                map.put(p,c);
//                log.info("put in map : {}",p);
//            }
//        }
//        log.info("map completed : {}", map);
//        model.addAttribute("products", map);
//        model.addAttribute("categories", categories);
//        model.addAttribute("productForm", new ProductForm());
//
//        return "management";
//    }

    @PostMapping("/management")
    public String register(ProductForm productForm) {
        ProductDTO newProductDTO = ProductDTO.builder()
                .name(productForm.getProductName())
                .category(productForm.getCategory())
                .price(productForm.getPrice())
                .quantity(productForm.getQuantity())
                .build();

        Product newProduct = newProductDTO.toEntity();
        log.info("product's category => {}",newProduct.getCategory());
        if (productService.findByName(newProduct.getProductName()).isEmpty()){
            productService.save(newProduct);
            log.info("product : {} is registered with\n price :{} and \nstock quantity : {}\n in category : {} ", newProduct.getProductName(), newProduct.getPrice(), newProduct.getQuantity(),newProduct.getCategory());
        }else{
            log.info("product name is duplicated one : {}", newProduct.getProductName());
        }

        return "redirect:/management";
    }

//    @RequestMapping
//    public String updateProduct() {
//        return null;
//    }
//
    @GetMapping("/management/delete")
    public String deleteProduct(@Param("productName") String productName) {
        try {
            Optional<Product> foundOne = productService.findByName(productName);
            productService.delete(foundOne.get().getProductId());
        }catch(Exception e){
            log.info("no product to deleted");
            return "redirect:/management";
        }

        return "redirect:/management";
    }
}

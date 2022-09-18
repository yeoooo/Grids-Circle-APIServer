package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/api/v1/product")
    public List<Product> productList(@RequestParam Optional<Category> category) {

        List<Product> products = category
                .map(productService::findByCategory)
                .orElse(productService.findAll());
        log.info("API REQUESTED ALL Product LOG => {}", products);

        return products;

    }



}

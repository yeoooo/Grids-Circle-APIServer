package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        List<Product> products = category
                .map(productService::findByCategory)
                .orElse(productService.findAll());

        return products;

    }

    @GetMapping("/api/v1/category")
    public List<Category> categories() {
        List<Category> categories = List.of(Category.values());
        return categories;

    }


}

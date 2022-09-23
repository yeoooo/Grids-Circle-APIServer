package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private final OrderService orderService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        List<Product> products = category
                .map(productService::findByCategory)
                .orElse(productService.findAll());
        log.info("API REQUESTED ALL Product LOG => {}", products);

        return products;

    }
    @GetMapping("/api/v1/category")
    public List<Category> categories() {
        List<Category> categories = List.of(Category.values());
        return categories;

    }
    @PostMapping("/api/v1/orders")
    public void orderRequest(@RequestBody Map<String, Object> lst) {
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email((String) lst.get("email"))
                .address((String) lst.get("address"))
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode((String) lst.get("postcode"))
                .orderItems(orderService.jsonToOrderItems(lst.get("orderItems")))
                .build();
        log.info("Got Param(lst) => {} ",newOrderDTO.getAddress());
        log.info("Got Param(Address) => {} ",newOrderDTO.getAddress());
        log.info("Got Param(postCode) => {} ",newOrderDTO.getPostcode());
        log.info("Got Param(email) => {} ",newOrderDTO.getEmail());
        log.info("Got Param(orderItems) => {} ",newOrderDTO.getOrderItems());

        orderService.order(newOrderDTO.getEmail(), newOrderDTO.getAddress(), newOrderDTO.getPostcode(), newOrderDTO.getOrderItems());

        }

}

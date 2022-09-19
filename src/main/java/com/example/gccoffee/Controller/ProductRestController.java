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
    @PostMapping("/api/v1/orders")
    public void orderRequest(@RequestBody Map<String, Object> lst) {
        OrderDTO newOrderDTO = OrderDTO.builder()
                .email((String) lst.get("email"))
                .address((String) lst.get("address"))
                .orderStatus(OrderStatus.ACCEPTED)
//                        .orderItems((HashMap<String, Object>)lst.get("orderItems"))
                .postcode((String) lst.get("postcode"))
                .orderItems(orderService.jsonToOrderItems(lst.get("orderItems")))
                .build();
        log.info("Got Param(lst) => {} ",newOrderDTO.getAddress());
        log.info("Got Param(Address) => {} ",newOrderDTO.getAddress());
        log.info("Got Param(postCode) => {} ",newOrderDTO.getPostcode());
        log.info("Got Param(email) => {} ",newOrderDTO.getEmail());
        log.info("Got Param(orderItems) => {} ",newOrderDTO.getOrderItems());

        orderService.order(newOrderDTO.getEmail(), newOrderDTO.getAddress(), newOrderDTO.getPostcode(), newOrderDTO.getOrderItems());

    



/**
 * PRODUCT_UUID = UUID.fromString((((LinkedHashMap<?, ?>) s).get("productId")).toString()))
 */

        }
//        log.info("Got Param(orderItems) => {} ",orderForm.getOrderItems());
//        orderForm.getOrderItems().stream().map(data ->
//                data.getProduct()
//        );

//        Order order = Order.builder().dto(newOrderDTO).build();
//        orderService.order(orderForm.getEmail(), orderForm.getAddress(), orderForm.getZipCode(), orderForm.getOrderItems());
//        for (OrderItem o : orderForm.getOrderItems()) {
//            log.info("got Param => {}", o);
//        }
//@PostMapping("/api/v1/orders")
//    public void orderRequest(@RequestBody
//                             Object orderForm) {
//        OrderDTO newOrderDTO = OrderDTO.builder()
//                .email(orderForm.getEmail())-9e99-2b
//                .orderStatus(OrderStatus.ACCEPTED)
//                .postcode(orderForm.getZipCode())
//                .orderItems(orderForm.getOrderItems())
//                .build();
//        log.info("Got Parma(Address) => {} ",orderForm.getAddress());
//        log.info("Got Parma(zipcode) => {} ",orderForm.getZipCode());
//        log.info("Got Parma(email) => {} ",orderForm.getEmail());
//        log.info("Got Parma(orderStatus) => {} ",orderForm.getOrderStatus());
//        log.info("Got Parma(orderItems) => {} ",orderForm.getOrderItems());
//        log.info("Got Param(Object) => {}", orderForm.orderItems);
//        Order order = Order.builder().dto(newOrderDTO).build();
//        orderService.order(orderForm.getEmail(), orderForm.getAddress(), orderForm.getZipCode(), orderForm.getOrderItems());
//        for (OrderItem o : orderForm.getOrderItems()) {
//            log.info("got Param => {}", o);
//        }



}

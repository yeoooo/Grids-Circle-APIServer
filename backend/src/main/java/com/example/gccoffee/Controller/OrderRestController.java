package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.OrderServiceImpl;
import com.example.gccoffee.model.OrderDTO;
import com.example.gccoffee.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/v1/orders")
    public void orderRequest(@RequestBody Map<String, Object> lst) {

        OrderDTO newOrderDTO = OrderDTO.builder()
                .email((String) lst.get("email"))
                .address((String) lst.get("address"))
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode((String) lst.get("postcode"))
                .orderItems(orderService.jsonToOrderItems(lst.get("orderItems")))
                .build();

        log.info("Order Requested : \n" +
                        "Got Param(Address) => {}\n" +
                        "Got Param(postCode) => {} \n" +
                        "Got Param(email) => {}\n" +
                        "Got Param(orderItems) => {} ",
                newOrderDTO.getAddress(),
                newOrderDTO.getPostcode(),
                newOrderDTO.getEmail(),
                newOrderDTO.getOrderItems());

        orderService.order(newOrderDTO.getEmail(), newOrderDTO.getAddress(), newOrderDTO.getPostcode(), newOrderDTO.getOrderItems());
    }
}

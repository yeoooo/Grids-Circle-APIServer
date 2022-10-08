package com.example.gccoffee.Controller;

import com.example.gccoffee.ApiResponse;
import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.model.OrderDTO;
import com.example.gccoffee.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/v1/orders")
        public ApiResponse<OrderDTO> orderRequest(@RequestBody HashMap<String, Object> map) {
            OrderDTO newOrderDTO = OrderDTO.builder()
//                .email(orderDTO.getEmail())
//                .address(orderDTO.getAddress())
//                .orderStatus(OrderStatus.ACCEPTED)
//                .postcode(orderDTO.getPostcode())
//                .orderItems(orderDTO.getOrderItems())
                .email((String) map.get("email"))
                .address((String) map.get("address"))
                .orderStatus(OrderStatus.ACCEPTED)
                .postcode((String) map.get("postcode"))
                .orderItems(orderService.jsonToOrderItems(map.get("orderItems")))
                .build();

        log.info("Order Requested : {}\n" +
                        "Got Param(Address) => {}\n" +
                        "Got Param(postCode) => {} \n" +
                        "Got Param(email) => {}\n" +
                        "Got Param(orderItems) =>{}\n "
                        ,
                newOrderDTO.toString(),
                newOrderDTO.getAddress(),
                newOrderDTO.getPostcode(),
                newOrderDTO.getEmail(),
                newOrderDTO.getOrderItems());

//        System.out.println("result = >" + orderDTO);
//        orderService.order(newOrderDTO.getEmail(), newOrderDTO.getAddress(), newOrderDTO.getPostcode(), newOrderDTO.getOrderItems());
        orderService.order(newOrderDTO);
        return ApiResponse.ok(newOrderDTO);
    }

}

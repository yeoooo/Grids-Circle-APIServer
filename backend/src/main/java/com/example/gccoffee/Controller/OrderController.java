package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.FormView;
import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

//    @GetMapping("/order")
//    public String order() {
//        return "order";
//    }

    @GetMapping("/management/order")
    public String getOrderList(Model model, @RequestParam(required = false)Optional<OrderStatus> status) {
        OrderStatus[] statuses = OrderStatus.values();
        List<OrderDTO> orders;

        if(status.isEmpty()) {
            orders = orderService.findAll().stream().map(
                    o -> OrderDTO.builder()
                            .id(o.getId())
                            .address(o.getAddress())
                            .email(o.getEmail())
                            .orderItems(o.getOrderItems())
                            .postcode(o.getPostcode())
                            .orderStatus(o.getOrderStatus())
                            .price(o.getTotalPrice())
                            .createdAt(o.getCreatedAt())
                            .updatedAt(o.getUpdatedAt())
                            .build()
            ).collect(Collectors.toList());
        }else {
            orders = orderService.findByOrderStatus(status.get()).stream()
                    .map(o ->
                            OrderDTO.builder()
                            .id(o.getId())
                            .address(o.getAddress())
                            .email(o.getEmail())
                            .orderItems(o.getOrderItems())
                            .postcode(o.getPostcode())
                            .orderStatus(o.getOrderStatus())
                            .price(o.getTotalPrice())
                            .createdAt(o.getCreatedAt())
                            .updatedAt(o.getUpdatedAt())
                            .build()
            ).collect(Collectors.toList());
        }
        log.info("OrderStatus requestParam is : {}", status.isPresent());
        model.addAttribute("orders", orders);
        model.addAttribute("status", statuses);
        return "order_management";


    }


    @RequestMapping("/management/order/update")
    public String changeOrderStatus(OrderUpdateForm orderUpdateForm) {
        log.info("id = {}_Order Status will be changed with => {}", orderUpdateForm.getId(),orderUpdateForm.getUpdateOrderStatus());
        orderService.changeOrderStatus(orderService.findById(orderUpdateForm.getId()).get(), orderUpdateForm.getUpdateOrderStatus());

        return "redirect:/management/order";

    }

}

package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.OrderService;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.ProductDTO;
import com.example.gccoffee.model.ProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/order_management")
    public String getOrderList(Model model) {
        model.addAttribute("orders",orderService.findAll());
        return "order_management";
    }
}

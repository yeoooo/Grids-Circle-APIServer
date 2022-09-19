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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.FormView;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
    public String getOrderList(Model model) {
        List<Order> orders = orderService.findAll();
        OrderStatus[] status = OrderStatus.values();
        HashMap<OrderStatus, List> map = new HashMap<>();

        Object[] mapKey = new Object[0];
        for (OrderStatus s : status) {//2022-09-14_yeoooo : 카테고리 이름 : 카테고리에 해당하는 제품
            map.put(s, orderService.findAll().stream().map(
                    order ->
                            OrderDTO.builder()
                                    .id(order.getId())
                                    .address(order.getAddress())
                                    .email(order.getEmail())
                                    .orderItems(order.getOrderItems())
                                    .postcode(order.getPostcode())
                                    .orderStatus(order.getOrderStatus())
                                    .price(order.getTotalPrice())
                                    .createdAt(order.getCreatedAt())
                                    .updatedAt(order.getUpdatedAt())
                                    .build()
            ).collect(Collectors.toList()));
            mapKey = map.keySet().toArray();
            Arrays.sort(mapKey);

//            Arrays.sort(Comparator.comparing());

        }
        log.info("map => {}",map);
        model.addAttribute("orders", map);
        model.addAttribute("status", mapKey);
        return "order_management";
    }
    @GetMapping("/order")
    public String getOrderListByStatus(Model model, @RequestParam(value = "category", required = false) Category category) {
        Category[] categories = Category.values();
        List<Product> products;
        if (category == null) {
            products = productService.findAll();
        }else{
            products = productService.findByCategory(category);
        }
        List<ProductDTO> dto = products.stream().map(
                product ->
                    ProductDTO.builder()
                            .name(product.getProductName())
                            .category(product.getCategory())
                            .price(product.getPrice())
                            .build()
        ).collect(Collectors.toList());


        model.addAttribute("products",dto);
        model.addAttribute("categories",categories);
        return "order";
    }

}

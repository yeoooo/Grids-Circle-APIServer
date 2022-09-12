package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("management")
    public String registry(Model model) {

        Category[] categories = Category.values();
        HashMap<ProductDTO,Category> map = new HashMap<>();
        for (Category c : categories) {
            List<ProductDTO> products = productService.findByCategory(c).stream().map(
                    product -> new ProductDTO(product.getProductName(),
                            product.getDescription(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getQuantity())
            ).collect(Collectors.toList());

            for (ProductDTO p : products) {
                map.put(p,c);
            }
        }
        model.addAttribute("products", map);
        model.addAttribute("categories", categories);

        return "management";
    }

//    @PostMapping("/index")
//    public String registry(Model model) {
//        return "index";
//    }

//    @RequestMapping
//    public String updateProduct() {
//        return null;
//    }
//
//    @RequestMapping
//    public String deleteProduct() {
//        return null;
//    }
}

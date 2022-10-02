package com.example.gccoffee.Controller;

import com.example.gccoffee.Exception.ErrorResult;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController extends BaseTimeEntity {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"/management/product", "/management/product/{variableCategory}"})
    public String getProductList(Model model, @PathVariable(value = "variableCategory", required = false) Optional<Category> category) {
        Category[] categories = Category.values();
        List<ProductDTO> products;

        if (category.isEmpty()) {
            products = productService.findAll().stream().map(
                    product -> new ProductDTO(
                            product.getProductId(),
                            product.getProductName(),
                            product.getDescription(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getQuantity(),
                            product.getCreatedAt(),
                            product.getUpdatedAt())
            ).collect(Collectors.toList());

        }else{
            products = productService.findByCategory(category.get()).stream().map(
                    product -> new ProductDTO(
                            product.getProductId(),
                            product.getProductName(),
                            product.getDescription(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getQuantity(),
                            product.getCreatedAt(),
                            product.getUpdatedAt())
            ).collect(Collectors.toList());;
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("productForm", new ProductForm());

        return "product_management";
    }

    @PostMapping("/management/product")
    public String register(@Valid @ModelAttribute ProductForm productForm) {
        ProductDTO newProductDTO = ProductDTO
                .builder()
                .name(productForm.getProductName())
                .category(productForm.getCategory())
                .price(productForm.getPrice())
                .quantity(productForm.getQuantity())
                .build();


        Product newProduct = newProductDTO.toEntity();
        log.info("product's category => {}",newProduct.getCategory());
        if (productService.findByName(newProduct.getProductName()).isEmpty()){
            productService.save(newProduct);
            log.info("product : {} is registered with\n price :{} and \nstock quantity : {}\n in category : {} ", newProduct.getProductName(), newProduct.getPrice(), newProduct.getQuantity(),newProduct.getCategory());
        }else{
            log.info("product name is duplicated one : {}", newProduct.getProductName());
        }

        return "redirect:/management/product";
    }
//    @PostMapping("/management/product")
//    public String register(@Valid @ModelAttribute ProductForm productForm) {
//        log.info(productForm.getProductName());
//
//        ProductDTO newProductDTO = ProductDTO
//                .builder()
//                .name(productForm.getProductName())
//                .category(productForm.getCategory())
//                .price(productForm.getPrice())
//                .quantity(productForm.getQuantity())
//                .build();
//
//
//        Product newProduct = newProductDTO.toEntity();
//        log.info("product's category => {}",newProduct.getCategory());
//        if (productService.findByName(newProduct.getProductName()).isEmpty()){
//            productService.save(newProduct);
//            log.info("product : {} is registered with\n price :{} and \nstock quantity : {}\n in category : {} ", newProduct.getProductName(), newProduct.getPrice(), newProduct.getQuantity(),newProduct.getCategory());
//        }else{
//            log.info("product name is duplicated one : {}", newProduct.getProductName());
//        }
//
//        return "redirect:/management/product";
//    }

    @RequestMapping("/management/product/update")
    public String updateProduct(@RequestParam("id") UUID id, @RequestParam("name") String productName, @RequestParam("price") long price, @RequestParam("quantity") int quantity, @RequestParam("description") String description) {
        Optional<Product> targetProduct = productService.findById(id);
            log.info("product updated => with\n" +
                    "id = {}\n"+
                    "name = {}\n"+
                    "price = {}\n"+
                    "quantity = {}\n"+
                    "description = {}\n",
                    targetProduct.get(),productName,price,quantity,description);
        if (targetProduct.isEmpty()) {
            throw new IllegalStateException("No Product found.");
        }else{
            productService.update(targetProduct.get(), productName, price, quantity, description);
        }

        return "redirect:/management/product";
    }
//
    @RequestMapping("/management/product/delete")
    public String deleteProduct(@RequestParam("id") UUID id) {
        log.info("requested delete from productId : {} ", id);
        try {
            Optional<Product> foundOne = productService.findById(id);
            productService.delete(foundOne.get().getProductId());
        }catch(Exception e){
            log.info("no product to deleted");
        }

        return "redirect:/management/product";
    }
}

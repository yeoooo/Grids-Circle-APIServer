package com.example.gccoffee.Controller;

import com.example.gccoffee.Exception.ErrorResult;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController extends BaseTimeEntity {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"/management/product", "/management/product/{variableCategory}"})
//    public String getProductList(Model model, @PathVariable(value = "variableCategory", required = false) Optional<Category> category, @RequestParam("errors") HashMap<String, ErrorResult> errors) {
    public String getProductList(Model model, @PathVariable(value = "variableCategory", required = false) Optional<Category> category, @RequestParam(value = "errors", required = false) String errors) {
//    public String getProductList(Model model, @PathVariable(value = "variableCategory", required = false) Optional<Category> category) {
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

        Map<String, String> errorMap = new HashMap<>();
        if (errors != null){
            Base64.Decoder decoder = Base64.getDecoder();
            String decoded = new String(decoder.decode(errors));
            log.info("map => {}",decoded);
//            List<String> res = List.of(decoded.replaceAll("[{}]", "").split(","));
            List<String> res = List.of(decoded.replaceAll("[{}]", "").split(",\\s"));

            for (String r : res) {
                String[] keyVal = r.split("=");
                errorMap.put(keyVal[0], keyVal[1]);
            }

        }
        log.info("map => {}", errorMap);
        log.info("map => {}", errorMap.keySet());
        log.info("map => {}", errorMap.get("productName"));
        log.info("map => {}", errorMap.get("price"));
        log.info("map => {}", errorMap.get("quantity"));
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("errors", errorMap);

        return "product_management";
    }

    @PostMapping("/management/product")
    public String register(@Valid ProductForm productForm, BindingResult result) {
        if(result.hasErrors()){
            Map<String,String> errorMessages = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            Base64.Encoder encoder = Base64.getEncoder();


            byte[] encoded = encoder.encode(errorMessages.toString().getBytes(StandardCharsets.UTF_8));
            log.info("requesting product to => {}", "redirect:/management/product?errors="+new String(encoded));
            return "redirect:/management/product?errors="+new String(encoded);

        }
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

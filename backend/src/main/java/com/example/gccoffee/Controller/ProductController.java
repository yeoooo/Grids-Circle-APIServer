package com.example.gccoffee.Controller;

import com.example.gccoffee.*;
import com.example.gccoffee.Exception.DuplicatedProductException;
import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Service.ProductService;
import com.example.gccoffee.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.protobuf.ProtoUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.protobuf.ProtobufDecoder;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.loader.internal.AliasConstantsHelper.get;

@Controller
@RequiredArgsConstructor
public class ProductController extends BaseTimeEntity {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();

    private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub = ProductServiceGrpc.newBlockingStub(channel);

    @GetMapping("/findAll")
    public String getProductList(Model model) {
        FindAllProductRequest req = FindAllProductRequest.newBuilder().build();
        FindAllProductResponse resp = blockingStub.findAll(req);
        List<ProductMessage> messages = resp.getProductList();

        List<ProductDTO> products;


        products = messages.stream().map(
                product -> new ProductDTO(
                        UUID.fromString(product.getProductId()),
                        product.getProductName(),
                        product.getDescription(),
                        Category.valueOf(product.getCategory()),
                        product.getPrice(),
                        product.getQuantity(),
                        LocalDateTime.now(),
                        LocalDateTime.now())
        ).collect(Collectors.toList());
        model.addAttribute("products", products);

            return "product_management";
    }

//    @GetMapping({"/management/product", "/management/product/{variableCategory}"})
//    public String getProductList(Model model, @PathVariable(value = "variableCategory", required = false) Optional<Category> category, @RequestParam(value = "errors", required = false) String errors) {
//        Category[] categories = Category.values();
//        List<ProductDTO> products;
//
//        if (category.isEmpty()) {
//            products = productService.findAll().stream().map(
//                    product -> new ProductDTO(
//                            product.getProductId(),
//                            product.getProductName(),
//                            product.getDescription(),
//                            product.getCategory(),
//                            product.getPrice(),
//                            product.getQuantity(),
//                            product.getCreatedAt(),
//                            product.getUpdatedAt())
//            ).collect(Collectors.toList());
//
//        }else{
//            products = productService.findByCategory(category.get()).stream().map(
//                    product -> new ProductDTO(
//                            product.getProductId(),
//                            product.getProductName(),
//                            product.getDescription(),
//                            product.getCategory(),
//                            product.getPrice(),
//                            product.getQuantity(),
//                            product.getCreatedAt(),
//                            product.getUpdatedAt())
//            ).collect(Collectors.toList());;
//        }
//
//        Map<String, String> errorMap = new HashMap<>();
//        if (errors != null){
//            Base64.Decoder decoder = Base64.getDecoder();
//            String decoded = new String(decoder.decode(errors));
//            List<String> res = List.of(decoded.replaceAll("[{}]", "").split(",\\s"));
//
//            for (String r : res) {
//                String[] keyVal = r.split("=");
//                errorMap.put(keyVal[0], keyVal[1]);
//            }
//
//        }
//        model.addAttribute("products", products);
//        model.addAttribute("categories", categories);
//        model.addAttribute("productForm", new ProductForm());
//        model.addAttribute("errors", errorMap);
//
//        return "product_management";
//    }

    @PostMapping("/management/product")
    public String register(@Valid ProductForm productForm) {
        ProductDTO newProductDTO = ProductDTO
                .builder()
                .name(productForm.getProductName())
                .category(productForm.getCategory())
                .price(productForm.getPrice())
                .quantity(productForm.getQuantity())
                .build();


        Product newProduct = newProductDTO.toEntity();
        if (productService.findByName(newProduct.getProductName()).isEmpty()){
            productService.save(newProduct);
            log.info("product : {} is registered with\n price :{} and \nstock quantity : {}\n in category : {} ", newProduct.getProductName(), newProduct.getPrice(), newProduct.getQuantity(),newProduct.getCategory());
        }else{
            log.info("product name is duplicated one : {}", newProduct.getProductName());
            throw new DuplicatedProductException("이미 같은 이름의 상품이 존재합니다.");
        }

        return "redirect:/management/product";
    }

    @RequestMapping("/management/product/update")
    public String updateProduct(@Valid ProductForm productForm) {
        Optional<Product> targetProduct = productService.findById(productForm.getId());
            log.info("product updated => with\n" +
                    "id = {}\n"+
                    "name = {}\n"+
                    "price = {}\n"+
                    "quantity = {}\n"+
                    "description = {}\n",
                    targetProduct.get(),productForm.getProductName(),productForm.getPrice(),productForm.getQuantity(),productForm.getDescription());
        if (targetProduct.isEmpty()) {
            throw new NoSuchProductException("상품이 존재하지 않습니다.");
        }else{
            productService.update(targetProduct.get(), productForm.getProductName(), productForm.getPrice(), productForm.getQuantity(), productForm.getDescription());
        }

        return "redirect:/management/product";
    }
//
    @RequestMapping("/management/product/delete")
    public String deleteProduct(@RequestParam("id") UUID id) {
        log.info("requested delete from productId : {} ", id);
        Optional<Product> foundOne = productService.findById(id);
        if(foundOne.isPresent()){
            productService.delete(foundOne.get().getProductId());
        }else{
            throw new NoSuchProductException("상품이 존재하지 않습니다.");
        }

        return "redirect:/management/product";
    }
}

package com.example.gccoffee.Service;

import com.example.gccoffee.*;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.ProductDTO;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GrpcProductClientService {
    @GrpcClient("management")
    private ProductServiceGrpc.ProductServiceBlockingStub blockingStub;


    public List<ProductDTO> findAll(Optional<Category> category) {
        try {
            FindAllProductRequest req;
            if (category.isEmpty()){
                req = FindAllProductRequest.newBuilder().build();
            }else{
                req = FindAllProductRequest.newBuilder().setCategory(category.get().toString()).build();
            }
            FindAllProductResponse resp = blockingStub.findAll(req);
            List<ProductMessage> messages = resp.getProductList();
            List<ProductDTO> products;

            if (category.isEmpty()) {
                products = messages.stream().map(
                        product -> new ProductDTO(
                                UUID.fromString(product.getProductId()),
                                product.getProductName(),
                                product.getDescription(),
                                Category.valueOf(product.getCategory()),
                                product.getPrice(),
                                product.getQuantity(),
                                LocalDateTime.parse(product.getCreatedAt()),
                                LocalDateTime.parse(product.getUpdatedAt()))
                ).collect(Collectors.toList());
            } else {
                products = messages.stream().map(
                        product -> new ProductDTO(
                                UUID.fromString(product.getProductId()),
                                product.getProductName(),
                                product.getDescription(),
                                Category.valueOf(product.getCategory()),
                                product.getPrice(),
                                product.getQuantity(),
                                LocalDateTime.parse(product.getCreatedAt()),
                                LocalDateTime.parse(product.getUpdatedAt()))
                ).collect(Collectors.toList());
                ;
        }
//                FindAllProductResponse resp = this.blockingStub.findAll(FindAllProductRequest.newBuilder().build());
//                return resp.getProductList().toString();
            return products;
            } catch(StatusRuntimeException e){
//                return "FAILED WITH" + e.getStatus().getCode().name();
                return new ArrayList<>();
            }

    }

    public String findById(String id) {
        try {
            FindOneProductResponse resp = this.blockingStub.findById(FindProductByIdRequest.newBuilder().setProductId(id).build());
            return resp.getProduct().toString();
        } catch (StatusRuntimeException e) {
            return "FAILED WITH" + e.getStatus().getCode().name();
        }

    }
    public String findByName(String name) {
        try{
            FindOneProductResponse resp = this.blockingStub.findByName(FindProductByNameRequest.newBuilder().setProductName(name).build());
            return resp.getProduct().toString();
        } catch (StatusRuntimeException e) {
            return "FAILED WITH" + e.getStatus().getCode().name();
        }
    }





}

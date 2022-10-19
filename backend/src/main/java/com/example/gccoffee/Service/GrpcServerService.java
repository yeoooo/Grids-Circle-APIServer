package com.example.gccoffee.Service;


import com.example.gccoffee.*;
import com.example.gccoffee.model.Product;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class GrpcServerService extends productServiceGrpc.productServiceImplBase{

    private final ProductService productService;


    @Override
    public void findAll(FindAllProductRequest request, StreamObserver<FindAllProductResponse> responseObserver) {
        List<Product> productList = productService.findAll();
        List<ProductMessage> products = new ArrayList<>();
        for(Product p : productList) {
            products.add(
            ProductMessage.newBuilder()
                    .setProductId(p.getProductId().toString())
                    .setProductName(p.getProductName())
                    .setPrice(p.getPrice())
                    .setCategory(p.getCategory().toString())
                    .setQuantity(p.getQuantity())
                    .setDescription(p.getDescription())
                    .build());
        }
        FindAllProductResponse resp = FindAllProductResponse.newBuilder().addAllProduct(products).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(FindProductByIdRequest request, StreamObserver<FindOneProductResponse> responseObserver) {
        Optional<Product> founded = productService.findById(UUID.fromString(request.getProductId()));
        ProductMessage productMessage = ProductMessage
                .newBuilder()
                .setProductId(founded.get().getProductId().toString())
                .setProductName(founded.get().getProductName())
                .setCategory(founded.get().getCategory().toString())
                .setPrice(founded.get().getPrice())
                .setDescription(founded.get().getDescription())
                .setQuantity(founded.get().getQuantity())
                .build();

        FindOneProductResponse resp = FindOneProductResponse.newBuilder().setProduct(productMessage).build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void findByName(FindProductByNameRequest request, StreamObserver<FindOneProductResponse> responseObserver) {
        System.out.println("request.getProductName() = " + request.getProductName());
        Optional<Product> founded = productService.findByName(request.getProductName());

        ProductMessage productMessage = ProductMessage
                .newBuilder()
                .setProductId(founded.get().getProductId().toString())
                .setProductName(founded.get().getProductName())
                .setCategory(founded.get().getCategory().toString())
                .setPrice(founded.get().getPrice())
                .setDescription(founded.get().getDescription())
                .setQuantity(founded.get().getQuantity())
                .build();

        FindOneProductResponse resp = FindOneProductResponse.newBuilder().setProduct(productMessage).build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();

    }
}

package com.example.gccoffee.Service;


import com.example.gccoffee.*;
import com.example.gccoffee.model.Product;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class GrpcServerService extends productServiceGrpc.productServiceImplBase{
    private final ProductService productService;

    @Override
    public void findAll(getAllProductsRequest request, StreamObserver<GetAllProductResponse> responseObserver) {
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
        GetAllProductResponse resp = GetAllProductResponse.newBuilder().addAllProduct(products).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void hello(helloRequest request, StreamObserver<helloResponse> responseObserver) {
        helloResponse resp = helloResponse.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}

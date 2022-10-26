package com.example.gccoffee.Service;

import com.example.gccoffee.*;
import io.grpc.StatusRuntimeException;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcProductClientService {
    @GrpcClient("management")
    private ProductServiceGrpc.ProductServiceBlockingStub blockingStub;

    public String findAll() {
        try {
            FindAllProductResponse resp = this.blockingStub.findAll(FindAllProductRequest.newBuilder().build());
            return resp.getProductList().toString();
        } catch (StatusRuntimeException e) {
            return "FAILED WITH" + e.getStatus().getCode().name();
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

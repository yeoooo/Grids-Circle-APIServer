package com.example.gccoffee.Service;

import com.example.gccoffee.GetAllProductResponse;
import com.example.gccoffee.ProductMessage;
import com.example.gccoffee.getAllProductsRequest;
import com.example.gccoffee.productServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcProductClientService {
    @GrpcClient("grpc/v1/products")
    private productServiceGrpc.productServiceBlockingStub productStub;

    public String sendMessage() {
        System.out.println( "gdgd");
        try {
            GetAllProductResponse resp = this.productStub.findAll(getAllProductsRequest.newBuilder().build());
            return resp.getProduct(1).toString();
        } catch (StatusRuntimeException e) {
            return "FAILED WITH" + e.getStatus().getCode().name();
        }
    }
}

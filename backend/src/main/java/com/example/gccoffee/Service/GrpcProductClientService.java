package com.example.gccoffee.Service;

import com.example.gccoffee.*;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcProductClientService {
    @GrpcClient("findAll")
//    @GrpcClient("test")
    private productServiceGrpc.productServiceBlockingStub productStub;

    public String sendMessage() {
        try {
            GetAllProductResponse resp = this.productStub.findAll(getAllProductsRequest.newBuilder().build());
            return resp.getProduct(1).toString();
        } catch (StatusRuntimeException e) {
            return "FAILED WITH" + e.getStatus().getCode().name();
        }
    }

//    public String sendMessage(final String name) {
//        try {
//            helloResponse resp = this.productStub.hello(helloRequest.newBuilder().setName(name).build());
//            return resp.getMessage();
//        } catch (StatusRuntimeException e) {
//            return "FAILED with " + e.getStatus().getCode().name();
//        }
//    }




}

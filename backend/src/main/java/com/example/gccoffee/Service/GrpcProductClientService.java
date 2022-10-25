package com.example.gccoffee.Service;

import com.example.gccoffee.*;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcProductClientService {
//    @GrpcClient("findProduct")
//    private productServiceGrpc.productServiceBlockingStub productStub;
//
//    public String findAll() {
//        try {
//            FindAllProductResponse resp = this.productStub.findAll(FindAllProductRequest.newBuilder().build());
//            return resp.getProductList().toString();
//        } catch (StatusRuntimeException e) {
//            return "FAILED WITH" + e.getStatus().getCode().name();
//        }
//    }
//
//    public String findById(String id) {
//        try {
//            FindOneProductResponse resp = this.productStub.findById(FindProductByIdRequest.newBuilder().setProductId(id).build());
//            return resp.getProduct().toString();
//        } catch (StatusRuntimeException e) {
//            return "FAILED WITH" + e.getStatus().getCode().name();
//        }
//
//    }
//    public String findByName(String name) {
//        try{
//            FindOneProductResponse resp = this.productStub.findByName(FindProductByNameRequest.newBuilder().setProductName(name).build());
//            return resp.getProduct().toString();
//        } catch (StatusRuntimeException e) {
//            return "FAILED WITH" + e.getStatus().getCode().name();
//        }
//    }

//    public String sendMessage(final String name) {
//        try {
//            helloResponse resp = this.productStub.hello(helloRequest.newBuilder().setName(name).build());
//            return resp.getMessage();
//        } catch (StatusRuntimeException e) {
//            return "FAILED with " + e.getStatus().getCode().name();
//        }
//    }




}

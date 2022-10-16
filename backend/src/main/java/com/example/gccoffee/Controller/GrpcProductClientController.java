package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.GrpcProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GrpcProductClientController {
    private final GrpcProductClientService grpcProductClientService;

    @GetMapping("grpc/v1/products")
    public String getProducts() {
        return grpcProductClientService.sendMessage();
    }
}
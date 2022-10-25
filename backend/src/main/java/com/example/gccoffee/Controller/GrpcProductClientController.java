package com.example.gccoffee.Controller;

import com.example.gccoffee.FindAllProductRequest;
import com.example.gccoffee.FindAllProductResponse;
import com.example.gccoffee.ProductMessage;
import com.example.gccoffee.productServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GrpcProductClientController {
//    private final GrpcProductClientService grpcProductClientService;

    @GrpcClient("findProduct")
    private productServiceGrpc.productServiceBlockingStub productStub;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        FindAllProductRequest req = FindAllProductRequest.newBuilder().build();
        FindAllProductResponse resp = productStub.findAll(req);
        List<ProductMessage> products = resp.getProductList();

        model.addAttribute("products", products);

        return "product_management";
    }
//
//    @GetMapping("/findById")
//    public String findById(@RequestParam("id") String id) {
////    public String findById(String id) {
//        return grpcProductClientService.findById(id);
//    }
//
//    @GetMapping("/findByName")
//    public String findByName(@RequestParam String name) {
////    public String findByName(String name) {
//        System.out.println("name = " + name);
//        return grpcProductClientService.findByName(name);
//    }

//    @GetMapping("/test")
//    public String printMessage() {
//        return grpcProductClientService.sendMessage();
//    }
}

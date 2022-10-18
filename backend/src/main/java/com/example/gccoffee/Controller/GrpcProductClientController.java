package com.example.gccoffee.Controller;

import com.example.gccoffee.Service.GrpcProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GrpcProductClientController {
    private final GrpcProductClientService grpcProductClientService;
//
    @GetMapping("/findAll")
    public String findAll() {
        return grpcProductClientService.findAll();
    }

    @GetMapping("/findById")
    public String findById(@RequestParam("id") String id) {
//    public String findById(String id) {
        return grpcProductClientService.findById(id);
    }

    @GetMapping("/findByName")
    public String findByName(@RequestParam String name) {
//    public String findByName(String name) {
        System.out.println("name = " + name);
        return grpcProductClientService.findByName(name);
    }

//    @GetMapping("/test")
//    public String printMessage() {
//        return grpcProductClientService.sendMessage();
//    }
}

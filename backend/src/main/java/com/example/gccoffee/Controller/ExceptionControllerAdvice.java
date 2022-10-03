package com.example.gccoffee.Controller;

import com.example.gccoffee.Exception.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
//@ControllerAdvice
public class ExceptionControllerAdvice {
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({BindException.class})
    public String productExHandler(BindException e, Model model) {
        BindingResult result = e.getBindingResult();
        HashMap<String,ErrorResult> errorMessages = new HashMap();
//        HashMap<String,String> errorMessages = new HashMap();
//        List<String> errorMessages = new ArrayList<>();
//
        for (FieldError fieldError : result.getFieldErrors()) {
            errorMessages.put(fieldError.getField(),new ErrorResult("BAD", fieldError.getDefaultMessage()));
//            errorMessages.put(fieldError.getField(),"gdgd");
//            errorMessages.add(fieldError.getField());
            log.error("productName test => {}", errorMessages.get("productName"));
            log.error("price test => {}", errorMessages.get("price"));
            log.error("quantity test => {}", errorMessages.get("quantity"));
            log.error("keySet test => {}", errorMessages.keySet());
        }
        log.error("[ProductManagementExceptionHandle] Errors has occurred => {}", errorMessages.toString());
        model.addAttribute("errors",errorMessages);
        return "product_management";
    }
}
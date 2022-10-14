package com.example.gccoffee.Controller;

import com.example.gccoffee.Exception.DuplicatedProductException;
import com.example.gccoffee.Exception.NoSuchOrderException;
import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Exception.ProductOnBoardException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {
    Map<String, String> errorMessages = new HashMap<>();
    Base64.Encoder encoder = Base64.getEncoder();

    @ExceptionHandler({BindException.class})
    public String productExHandler(BindingResult result) {
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        byte[] encoded = encoder.encode(errorMessages.toString().getBytes(StandardCharsets.UTF_8));
            log.error("[productExHandler] request To => {}", "redirect:/management/product?errors=" + new String(encoded));
            return "redirect:/management/product?errors=" + new String(encoded);
    }
    @ExceptionHandler({DuplicatedProductException.class, NoSuchProductException.class, NoSuchOrderException.class, ProductOnBoardException.class})
    public String CommonExHandler(RuntimeException e) {
        errorMessages.put("common", e.getMessage());
        byte[] encoded = encoder.encode(errorMessages.toString().getBytes(StandardCharsets.UTF_8));
        log.error("[CommonExHandler] : {}", e.getMessage());
        return "redirect:/management/product?errors=" + new String(encoded);

    }

}

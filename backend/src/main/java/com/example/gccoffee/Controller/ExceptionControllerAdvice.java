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

import java.util.HashMap;


@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public String productExHandler(BindException e, Model model) {
        BindingResult result = e.getBindingResult();
        HashMap<String,ErrorResult> errorMessages = new HashMap();

        for (FieldError fieldError : result.getFieldErrors()) {
            errorMessages.put(fieldError.getField(),new ErrorResult("BAD", fieldError.getDefaultMessage()));
            log.error("test => {}", errorMessages.get("productName"));
            log.error("test => {}", errorMessages.get("price"));
            log.error("test => {}", errorMessages.get("quantity"));
        }
        log.error("[ProductManagementExceptionHandle] Errors has occurred => {}", errorMessages.toString());
        model.addAttribute("errors",errorMessages);
        return "redirect:/management/product";
    }
}
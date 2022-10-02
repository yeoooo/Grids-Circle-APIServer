package com.example.gccoffee.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class ErrorResult {
    private String code;
    private String message;
//    private List<FieldError> errors = new ArrayList<>();
}


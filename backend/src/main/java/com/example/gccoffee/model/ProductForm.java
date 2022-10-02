package com.example.gccoffee.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductForm {
    private Long id;
    @NotEmpty(message = "상품 이름은 비어있으면 안됩니다!")
//    @NotBlank
    private String productName;
    private Category category;
    @Min(value = 1, message = "가격은 1 이상이어야 합니다!")
    private long price;
    @Min(value = 1, message = "재고는 1 이상이어야 합니다!")
    private int quantity;




}


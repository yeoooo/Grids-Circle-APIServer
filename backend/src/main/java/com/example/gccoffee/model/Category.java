package com.example.gccoffee.model;

import lombok.Getter;

@Getter
public enum Category {
//    COFFEE_BEAN_PACKAGE
//    ,COFFEE_CUP;
    BEAN("커피 콩"),
    CUP("커피 컵");
//
    public final String category;

    private Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}

package com.example.gccoffee.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    public void getAllEnum() throws Exception {
        Category[] list = Category.values();
        for (Category e : list) {
            System.out.println(e);
        }


    }

}
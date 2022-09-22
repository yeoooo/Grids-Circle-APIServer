package com.example.gccoffee.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class TimeTest {


    @Test
    public void TimeTest() throws Exception {
        //given
        LocalDateTime localDateTime = LocalDateTime.now().withHour(14).withMinute(0).withSecond(0).withNano(0);
        //when
        System.out.println(localDateTime);
        //then
        System.out.println(LocalDate.now().withYear(2022).withMonth(9).withDayOfMonth(7));
//        System.out.println(System.out.println(LocalDate.now().withYear(2022).withMonth(5).withDayOfMonth(13));
//        System.out.println(System.out.println(LocalDate.now().withYear(2022).withMonth(5).withDayOfMonth(13));
//        System.out.println(System.out.println(LocalDate.now().withYear(2022).withMonth(5).withDayOfMonth(13));
//        System.out.println(System.out.println(LocalDate.now().withYear(2022).withMonth(5).withDayOfMonth(12));

    }
}

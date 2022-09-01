package com.example.gccoffee.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

@Test
@DisplayName("입력은 유효한 이메일 형식이어야 한다.")
public void EmailTest() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> {
        Email email = new Email("asdfgsdfgsdgf");
    });
}

@Test
@DisplayName("길이는 4에서 50 사이이어야 한다.")
public void EmailLengthTest() throws Exception {
    //given
    assertThrows(IllegalArgumentException.class, () -> {
        Email email = new Email("a");
    });
}

}
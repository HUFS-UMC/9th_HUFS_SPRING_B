package com.example.umc9th.domain.user.exception;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserSuccessCode implements BaseSuccessCode {
    LOGIN_SUCCESS(HttpStatus.OK, "USER2001", "로그인 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

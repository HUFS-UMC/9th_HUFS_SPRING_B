package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "REVIEW200_1", "리뷰 목록 조회 성공");

    private final HttpStatus Status;
    private final String code;
    private final String message;
}



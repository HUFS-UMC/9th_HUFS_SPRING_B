package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    // 가게 리뷰 목록 조회
    FOUND(HttpStatus.OK, "REVIEW200_1", "리뷰 목록 조회 성공"),


    // ✅ 새로 추가 — 내가 작성한 리뷰 목록 조회
    FOUND_MY_REVIEWS(HttpStatus.OK, "REVIEW200_2", "내 리뷰 목록 조회 성공");


    private final HttpStatus Status;
    private final String code;
    private final String message;
}



package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    SUCCESS(HttpStatus.OK, "COMMON200", "성공적으로 요청이 처리되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

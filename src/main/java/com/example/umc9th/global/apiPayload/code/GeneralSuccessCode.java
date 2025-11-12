package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    OK("COMMON200", "성공적으로 요청이 처리되었습니다.");
    private final String code;
    private final String message;

}

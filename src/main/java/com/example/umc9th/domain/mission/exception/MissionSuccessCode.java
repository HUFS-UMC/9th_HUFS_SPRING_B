package com.example.umc9th.domain.mission.exception;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    FOUND_MISSIONS(HttpStatus.OK, "MISSION200_1", "미션 목록 조회 성공"),
    FOUND_IN_PROGRESS_MISSIONS(HttpStatus.OK, "MISSION200_2", "진행중 미션 목록 조회 성공");

    private final HttpStatus Status;
    private final String code;
    private final String message;
}

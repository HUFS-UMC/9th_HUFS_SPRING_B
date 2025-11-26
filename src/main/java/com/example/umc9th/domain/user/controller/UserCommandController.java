package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.UserSignUpRequest;
import com.example.umc9th.domain.user.dto.UserSignUpResponse;
import com.example.umc9th.domain.user.service.UserCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserCommandController {

    private final UserCommandService userCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<UserSignUpResponse> signUp(@RequestBody UserSignUpRequest dto) {

        return ApiResponse.onSuccess(
                GeneralSuccessCode.SUCCESS,   // 또는 UserSuccessCode.CREATED
                userCommandService.signUp(dto)
        );
    }
}

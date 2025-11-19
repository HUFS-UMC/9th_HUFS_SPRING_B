package com.example.umc9th.domain.user.dto;

import com.example.umc9th.domain.user.enums.Gender;

import java.util.List;

public record UserSignUpRequest(
        String email,
        String password,
        String name,
        Gender gender,
        String address,
        String phoneNumber,
        List<Long> preferFoods   // Food ID 리스트
) {}

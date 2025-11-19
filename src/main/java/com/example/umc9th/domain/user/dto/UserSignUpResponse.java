package com.example.umc9th.domain.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserSignUpResponse(
        Long userId,
        LocalDateTime createdAt
) {}

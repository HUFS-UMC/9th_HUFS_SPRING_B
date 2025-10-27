package com.example.umc9th.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPointResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private Long totalPoint;
}

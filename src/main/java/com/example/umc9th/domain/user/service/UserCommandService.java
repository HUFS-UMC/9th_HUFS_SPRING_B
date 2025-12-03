package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.dto.UserSignUpRequest;
import com.example.umc9th.domain.user.dto.UserSignUpResponse;

public interface UserCommandService {
    UserSignUpResponse signUp(UserSignUpRequest dto);
}

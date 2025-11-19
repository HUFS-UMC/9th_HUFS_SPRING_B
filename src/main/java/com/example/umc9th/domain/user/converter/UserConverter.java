package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.UserSignUpRequest;
import com.example.umc9th.domain.user.dto.UserSignUpResponse;
import com.example.umc9th.domain.user.entity.User;

public class UserConverter {

    // DTO → Entity
    public static User toUser(UserSignUpRequest dto) {
        return User.builder()
                .email(dto.email())
                .password(dto.password())
                .name(dto.name())
                .gender(dto.gender())
                .address(dto.address())
                .phoneNumber(dto.phoneNumber())
                .build();
    }

    // Entity → DTO
    public static UserSignUpResponse toSignUpDTO(User user) {
        return UserSignUpResponse.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

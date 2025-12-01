package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.UserSignUpRequest;
import com.example.umc9th.domain.user.dto.UserSignUpResponse;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.auth.enums.Role;

public class UserConverter {

    // DTO → Entity
    public static User toUser(UserSignUpRequest dto, String encodedPassword, Role role) {
        return User.builder()
                .email(dto.email())
                .password(encodedPassword)
                .name(dto.name())
                .role(role)
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

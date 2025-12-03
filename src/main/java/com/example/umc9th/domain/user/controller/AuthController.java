package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.LoginRequest;
import com.example.umc9th.domain.user.dto.LoginResponse;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.exception.UserSuccessCode;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.auth.jwt.JwtProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    /**
     * POST /auth/sign-in
     */
    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @RequestBody LoginRequest request,
            HttpServletResponse response
    ) {
        // 1) 사용자 조회
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        // 2) 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 3) AccessToken & RefreshToken 생성
        String accessToken = jwtProvider.generateAccessToken(user.getId(), user.getRole().name());
        String refreshToken = jwtProvider.generateRefreshToken(user.getId());

        // 4) RefreshToken → HttpOnly Cookie 로 반환
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // HTTPS 배포 시 true로 변경
        cookie.setMaxAge(60 * 60 * 24 * 14); // 14일
        response.addCookie(cookie);

        // 5) AccessToken → Header에 저장
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        // 6) Body 응답 데이터
        return ResponseEntity.ok(
                ApiResponse.onSuccess(
                        UserSuccessCode.LOGIN_SUCCESS,
                        new LoginResponse(user.getId(), accessToken)
                )
        );
    }
}

package com.example.umc9th.domain.user.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "social_account")
public class SocialAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ex) KAKAO, GOOGLE, NAVER
    @Column(name = "social_type", nullable = false, length = 20)
    private String socialType;

    @Column(name = "social_id", nullable = false, length = 30)
    private String socialId;

    @Column(name = "refresh_token", length = 255)
    private String refreshToken;

    @Column(name = "email", length = 50)
    private String email;

    // N:1 관계 (여러 소셜계정 → 한 유저)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

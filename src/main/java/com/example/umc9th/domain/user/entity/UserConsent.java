package com.example.umc9th.domain.user.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "user_consent")
public class UserConsent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @Column(name = "location_agree", nullable = false)
    private Boolean locationAgree;

    @Column(name = "marketing_agree", nullable = false)
    private Boolean marketingAgree;

    // N:1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

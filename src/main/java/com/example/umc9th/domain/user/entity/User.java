package com.example.umc9th.domain.user.entity;


import com.example.umc9th.domain.point.entity.PointHistory;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.user.entity.mapping.PreferredFood;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.auth.enums.Role;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "address", length = 40, nullable = false)
    private String address;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<PreferredFood> preferredFoods = new ArrayList<>();

    // cascade 고려?
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<UserMission> userMissions = new ArrayList<>();

    //
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    // 단방향 1:1 (User → UserConsent)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_consent_id", foreignKey = @ForeignKey(name = "fk_user_user_consent"))
    private UserConsent userConsent;

    // cascade는 일단 안함
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<UserAlarm> userAlarms = new ArrayList<>();

    // 1:n pointHistory
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<PointHistory> pointHistories = new ArrayList<>();

    // --- 편의 메서드 ---
    public void addPreferredFood(PreferredFood preferredFood) {
        preferredFoods.add(preferredFood);
    }

    public void removePreferredFood(PreferredFood preferredFood) {
        preferredFoods.remove(preferredFood);
    }
}

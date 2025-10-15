package com.example.umc9th.domain.user.entity;

import com.example.umc9th.domain.user.entity.mapping.PreferredFood;
import com.example.umc9th.domain.user.enums.Gender;
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
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

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

    // 🔹 연관관계 설정 (1:N)
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PreferredFood> preferredFoods = new ArrayList<>();

    // 편의 메서드
    public void addPreferredFood(PreferredFood preferredFood) {
        preferredFoods.add(preferredFood);
    }
}

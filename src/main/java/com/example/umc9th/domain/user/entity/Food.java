package com.example.umc9th.domain.user.entity;

import com.example.umc9th.domain.user.entity.mapping.PreferredFood;
import com.example.umc9th.domain.user.enums.FoodName;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "food")
@Builder
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, length = 20)
    private FoodName name;

    // 연관관계 (1:N)
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<PreferredFood> preferredFoods = new ArrayList<>();
}

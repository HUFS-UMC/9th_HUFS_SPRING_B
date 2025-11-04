package com.example.umc9th.domain.user.entity.mapping;

import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "preferred_food")
public class PreferredFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Food (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    // 생성자
    public PreferredFood(User user, Food food) {
        this.user = user;
        this.food = food;
    }
}

package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.entity.User;
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
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 평점 (소수점 1자리까지)
    @Column(nullable = false, precision = 2)
    private Double rating;

    // 리뷰 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 리뷰 이미지 (1:N)
    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ReviewImage> reviewImages = new ArrayList<>();

    //리뷰 답변 (1:N)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ReviewAnswer> reviewAnswers = new ArrayList<>();

    // 작성자 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 리뷰 대상 매장 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}

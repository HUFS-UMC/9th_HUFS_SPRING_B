package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String storeName;
    private String userName;
    private double rating;
    private String content;

    public ReviewResponse(Long id, Double rating, String content, String storeName, String userName) {
        this.id = id;
        this.rating = Math.round(rating * 10) / 10.0; // ★ 소수점 첫째 자리 반올림
        this.content = content;
        this.storeName = storeName;
        this.userName = userName;
    }
}
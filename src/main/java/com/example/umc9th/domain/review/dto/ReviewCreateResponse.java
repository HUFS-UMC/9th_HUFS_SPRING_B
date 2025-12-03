package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewCreateResponse {

    private Long reviewId;
    private Long storeId;
    private Double rating;
    private String content;
}

package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewResponse>> searchMyReviews(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Double rating
    ) {
        List<ReviewResponse> reviews = reviewQueryService.getMyReviews(userId, storeName, rating);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}

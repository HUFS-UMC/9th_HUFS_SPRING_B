package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    // 인터페이스에 의존하도록 변경
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    /**
     * 리뷰 조회 API
     * GET /api/reviews/search
     */
    @GetMapping("/search")
    public ApiResponse<List<ReviewResponse>> searchMyReviews(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Double rating
    ) {
        List<ReviewResponse> reviews = reviewQueryService.getMyReviews(userId, storeName, rating);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }

    /**
     * 리뷰 생성 API (테스트용)
     * POST /api/reviews/create
     */
    @PostMapping("/create")
    public ApiResponse<Void> createReview() {
        reviewCommandService.createReview();
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}

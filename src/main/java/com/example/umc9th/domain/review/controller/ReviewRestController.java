package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.ReviewSuccessCode;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.resolver.PositivePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/reviews")
public class ReviewRestController {

    private final ReviewQueryService reviewQueryService;

    @Operation(
            summary = "[마크] 가게 리뷰 목록 조회 API (개발중)",
            description = "특정 가게 이름(storeName)에 대한 리뷰 목록을 페이지네이션 방식으로 조회한다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게 없음")
    })
    @GetMapping
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @PositivePage Integer page     // 🔥 RequestParam 대신 여기에 적용!
    ) {
        ReviewResDTO.ReviewPreViewListDTO result = reviewQueryService.findReview(storeName, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND, result);
    }
}

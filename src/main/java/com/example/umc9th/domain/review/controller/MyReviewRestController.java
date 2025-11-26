package com.example.umc9th.domain.review.controller;

import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MyReviewRestController {

    private final ReviewQueryService reviewQueryService;

    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 API",
            description = "userId 기준으로 본인이 작성한 리뷰를 10개씩 페이징 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/{userId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        ReviewResDTO.ReviewPreViewListDTO result =
                reviewQueryService.findMyReviews(userId, page);

        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND_MY_REVIEWS, result);
    }
}

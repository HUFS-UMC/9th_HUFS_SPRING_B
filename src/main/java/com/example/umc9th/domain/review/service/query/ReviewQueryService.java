package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import java.util.List;

public interface ReviewQueryService {
    List<ReviewResponse> getMyReviews(Long userId, String storeName, Double rating);

    ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);

    //  새로 추가 — 내가 작성한 리뷰 목록(페이징, 10개씩)
    ReviewResDTO.ReviewPreViewListDTO findMyReviews(Long userId, Integer page);
}

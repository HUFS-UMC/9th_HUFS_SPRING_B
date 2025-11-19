package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.dto.ReviewCreateRequest;
import com.example.umc9th.domain.review.dto.ReviewCreateResponse;

public interface ReviewCommandService {

    ReviewCreateResponse createReview(Long storeId, ReviewCreateRequest request);

}

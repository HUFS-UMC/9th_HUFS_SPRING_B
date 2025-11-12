package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getMyReviews(Long userId, String storeName, Double rating) {
        List<Review> reviews = reviewRepository.searchMyReviews(userId, storeName, rating);

        return reviews.stream()
                .map(r -> new ReviewResponse(
                        r.getId(),
                        r.getRating(),
                        r.getContent(),
                        r.getStore().getName(),
                        r.getUser().getName()
                ))
                .collect(Collectors.toList());
    }
}

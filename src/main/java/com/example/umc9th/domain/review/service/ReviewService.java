package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public void createReview() {
        User user = userRepository.findById(1L).orElseThrow();
        Store store = storeRepository.findById(3L).orElseThrow();

        Review review = Review.builder()
                .rating(5.0)
                .content("음 너무 맛있어요 포인트 ~")
                .user(user)
                .store(store)
                .build();

        reviewRepository.save(review);
    }
}

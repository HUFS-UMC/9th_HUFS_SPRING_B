package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.dto.ReviewCreateRequest;
import com.example.umc9th.domain.review.dto.ReviewCreateResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewCreateResponse createReview(Long storeId, ReviewCreateRequest request) {

        // 로그인 기능 없으므로 하드코딩
        Long hardUserId = 1L;
        User user = userRepository.findById(hardUserId)
                .orElseThrow();

        Store store = storeRepository.findById(storeId)
                .orElseThrow();

        Review review = Review.builder()
                .rating(request.getRating())
                .content(request.getContent())
                .user(user)
                .store(store)
                .build();

        Review saved = reviewRepository.save(review);

        return ReviewCreateResponse.builder()
                .reviewId(saved.getId())
                .storeId(storeId)
                .rating(saved.getRating())
                .content(saved.getContent())
                .build();
    }
}

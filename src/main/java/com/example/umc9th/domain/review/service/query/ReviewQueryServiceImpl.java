package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreErrorCode;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.repository.StoreRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    /**
     * ⭐ 기존 기능 — 특정 유저가 작성한 리뷰 조회
     */
    @Override
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

    /**
     * ⭐ 새 기능 — 특정 가게 리뷰 목록 조회 (페이징)
     */
    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page) {

        // 가게 존재 여부 검증
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 페이징 (page = 1부터 요청 → JPA는 0부터)
        PageRequest pageable = PageRequest.of(page - 1, 5);

        Page<Review> result = reviewRepository.findAllByStore(store, pageable);

        // 변환 후 반환
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    /**
     * ✅ 새 기능 — 내가 작성한 리뷰 목록 조회 (페이징, 10개씩)
     */
    @Override
    public ReviewResDTO.ReviewPreViewListDTO findMyReviews(Long userId, Integer page) {

        // page 는 프론트에서 1부터 보내므로 -1
        PageRequest pageable = PageRequest.of(page - 1, 10);

        Page<Review> result = reviewRepository.findAllByUser_Id(userId, pageable);

        // Converter 이용해서 DTO로 변환
        return ReviewConverter.toReviewPreviewListDTO(result);
    }
}

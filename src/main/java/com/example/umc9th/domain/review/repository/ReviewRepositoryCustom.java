package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> searchMyReviews(Long userId, String storeName, Double rating);
}

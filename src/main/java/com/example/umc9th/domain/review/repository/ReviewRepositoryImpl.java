package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.user.entity.QUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.umc9th.domain.review.entity.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> searchMyReviews(Long userId, String storeName, Double rating) {
        QReview review = QReview.review;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(
                        review.user.id.eq(userId),
                        storeName != null ? store.name.eq(storeName) : null,
                        rating != null ? review.rating.goe(rating) : null
                )
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}

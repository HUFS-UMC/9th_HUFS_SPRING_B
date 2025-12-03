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

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.user.id.eq(userId));

        if (storeName != null && !storeName.isEmpty()) {
            builder.and(store.name.eq(storeName));
        }

        if (rating != null) {
            builder.and(review.rating.goe(rating));
        }

        return queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }

}

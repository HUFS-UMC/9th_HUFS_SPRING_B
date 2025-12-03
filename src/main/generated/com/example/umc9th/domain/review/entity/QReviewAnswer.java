package com.example.umc9th.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewAnswer is a Querydsl query type for ReviewAnswer
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAnswer extends EntityPathBase<ReviewAnswer> {

    private static final long serialVersionUID = -1277184262L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewAnswer reviewAnswer = new QReviewAnswer("reviewAnswer");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReview review;

    public final com.example.umc9th.domain.store.entity.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewAnswer(String variable) {
        this(ReviewAnswer.class, forVariable(variable), INITS);
    }

    public QReviewAnswer(Path<? extends ReviewAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewAnswer(PathMetadata metadata, PathInits inits) {
        this(ReviewAnswer.class, metadata, inits);
    }

    public QReviewAnswer(Class<? extends ReviewAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
        this.store = inits.isInitialized("store") ? new com.example.umc9th.domain.store.entity.QStore(forProperty("store")) : null;
    }

}


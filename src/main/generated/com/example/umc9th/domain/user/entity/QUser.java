package com.example.umc9th.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1601831614L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.example.umc9th.domain.user.enums.Gender> gender = createEnum("gender", com.example.umc9th.domain.user.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.example.umc9th.domain.point.entity.PointHistory, com.example.umc9th.domain.point.entity.QPointHistory> pointHistories = this.<com.example.umc9th.domain.point.entity.PointHistory, com.example.umc9th.domain.point.entity.QPointHistory>createList("pointHistories", com.example.umc9th.domain.point.entity.PointHistory.class, com.example.umc9th.domain.point.entity.QPointHistory.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc9th.domain.user.entity.mapping.PreferredFood, com.example.umc9th.domain.user.entity.mapping.QPreferredFood> preferredFoods = this.<com.example.umc9th.domain.user.entity.mapping.PreferredFood, com.example.umc9th.domain.user.entity.mapping.QPreferredFood>createList("preferredFoods", com.example.umc9th.domain.user.entity.mapping.PreferredFood.class, com.example.umc9th.domain.user.entity.mapping.QPreferredFood.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview> reviews = this.<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview>createList("reviews", com.example.umc9th.domain.review.entity.Review.class, com.example.umc9th.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc9th.global.auth.enums.Role> role = createEnum("role", com.example.umc9th.global.auth.enums.Role.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<UserAlarm, QUserAlarm> userAlarms = this.<UserAlarm, QUserAlarm>createList("userAlarms", UserAlarm.class, QUserAlarm.class, PathInits.DIRECT2);

    public final QUserConsent userConsent;

    public final ListPath<com.example.umc9th.domain.user.entity.mapping.UserMission, com.example.umc9th.domain.user.entity.mapping.QUserMission> userMissions = this.<com.example.umc9th.domain.user.entity.mapping.UserMission, com.example.umc9th.domain.user.entity.mapping.QUserMission>createList("userMissions", com.example.umc9th.domain.user.entity.mapping.UserMission.class, com.example.umc9th.domain.user.entity.mapping.QUserMission.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userConsent = inits.isInitialized("userConsent") ? new QUserConsent(forProperty("userConsent")) : null;
    }

}


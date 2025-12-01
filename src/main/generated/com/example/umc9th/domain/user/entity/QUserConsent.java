package com.example.umc9th.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserConsent is a Querydsl query type for UserConsent
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserConsent extends EntityPathBase<UserConsent> {

    private static final long serialVersionUID = -1657779080L;

    public static final QUserConsent userConsent = new QUserConsent("userConsent");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRequired = createBoolean("isRequired");

    public final BooleanPath locationAgree = createBoolean("locationAgree");

    public final BooleanPath marketingAgree = createBoolean("marketingAgree");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUserConsent(String variable) {
        super(UserConsent.class, forVariable(variable));
    }

    public QUserConsent(Path<? extends UserConsent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserConsent(PathMetadata metadata) {
        super(UserConsent.class, metadata);
    }

}


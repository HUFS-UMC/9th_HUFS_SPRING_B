package com.example.umc9th.domain.user.entity.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferredFood is a Querydsl query type for PreferredFood
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferredFood extends EntityPathBase<PreferredFood> {

    private static final long serialVersionUID = -1323089208L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferredFood preferredFood = new QPreferredFood("preferredFood");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final com.example.umc9th.domain.user.entity.QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc9th.domain.user.entity.QUser user;

    public QPreferredFood(String variable) {
        this(PreferredFood.class, forVariable(variable), INITS);
    }

    public QPreferredFood(Path<? extends PreferredFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferredFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferredFood(PathMetadata metadata, PathInits inits) {
        this(PreferredFood.class, metadata, inits);
    }

    public QPreferredFood(Class<? extends PreferredFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new com.example.umc9th.domain.user.entity.QFood(forProperty("food")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc9th.domain.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}


package com.example.umc9th.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAlarm is a Querydsl query type for UserAlarm
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAlarm extends EntityPathBase<UserAlarm> {

    private static final long serialVersionUID = 420906543L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAlarm userAlarm = new QUserAlarm("userAlarm");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath dtype = createString("dtype");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRead = createBoolean("isRead");

    public final DateTimePath<java.time.LocalDateTime> readAt = createDateTime("readAt", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserAlarm(String variable) {
        this(UserAlarm.class, forVariable(variable), INITS);
    }

    public QUserAlarm(Path<? extends UserAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAlarm(PathMetadata metadata, PathInits inits) {
        this(UserAlarm.class, metadata, inits);
    }

    public QUserAlarm(Class<? extends UserAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


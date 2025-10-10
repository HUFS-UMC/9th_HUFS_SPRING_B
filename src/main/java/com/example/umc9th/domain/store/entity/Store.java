package com.example.umc9th.domain.store.entity;

import com.example.umc9th.domain.point.entity.PointHistory;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "store")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String address;

    @Column(precision = 10)// scale == 정밀도
    private Double latitude;

    @Column(precision = 10)
    private Double longitude;

    // 리뷰 (1:N) 일단 주석처리
    // @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //  private List<Review> reviews = new ArrayList<>();

    // 단방향 설계를 위해 주석처리 포인트 내역 (1:N)
//    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private List<PointHistory> pointHistories = new ArrayList<>();
}

package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
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
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(name = "reward_point", nullable = false)
    private Integer rewardPoint;

    // Store (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    // UserMission (1:N)
    // 단방향 연관관계를 위해 주석처리
//   @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UserMission> userMissions = new ArrayList<>();
}

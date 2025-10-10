package com.example.umc9th.domain.user.entity.mapping;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "user_mission")
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 미션 상태 (ENUM으로 관리 권장)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus status;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    // User (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Mission (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;
}

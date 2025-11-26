package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserMissionProgressResponse {

    private Long missionId;
    private String title;
    private Integer rewardPoint;
    private String storeName;
    private MissionStatus status;
    private LocalDateTime requestedAt;
}

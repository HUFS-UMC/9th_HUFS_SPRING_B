package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus; // 존재한다면 import
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserMissionStatusResponse {
    private Integer rewardPoint;
    private String storeName;
    private MissionStatus status;
}
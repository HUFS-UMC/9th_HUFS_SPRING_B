package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionListResponse {
    private Long missionId;
    private String title;
    private Integer rewardPoint;
    private String storeName;
    private String address;
}

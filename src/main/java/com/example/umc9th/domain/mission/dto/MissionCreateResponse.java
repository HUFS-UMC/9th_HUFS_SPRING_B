package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionCreateResponse {
    private Long missionId;
    private Long storeId;
    private String title;
    private Integer rewardPoint;
}

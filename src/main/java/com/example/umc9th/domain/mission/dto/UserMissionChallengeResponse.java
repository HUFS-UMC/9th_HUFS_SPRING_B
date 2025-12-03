package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMissionChallengeResponse {
    private Long userMissionId;
    private Long missionId;
    private Long userId;
    private String status;
}

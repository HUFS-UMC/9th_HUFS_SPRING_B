package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.UserMissionChallengeRequest;
import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;

public interface UserMissionCommandService {
    UserMissionChallengeResponse requestMission(Long storeId, UserMissionChallengeRequest request);
}

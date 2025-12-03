package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;
import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import org.springframework.data.domain.Page;

public interface UserMissionCommandService {
    UserMissionChallengeResponse requestMission(Long storeId, Long missionId);
    Page<UserMissionProgressResponse> completeMission(Long userId, Long userMissionId, Integer page);
}
package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MissionCreateRequest;
import com.example.umc9th.domain.mission.dto.MissionCreateResponse;

public interface MissionCommandService {
    MissionCreateResponse createMission(Long storeId, MissionCreateRequest request);
}

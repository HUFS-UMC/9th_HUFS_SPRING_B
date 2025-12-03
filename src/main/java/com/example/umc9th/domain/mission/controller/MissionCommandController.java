package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionCreateRequest;
import com.example.umc9th.domain.mission.dto.MissionCreateResponse;
import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.command.UserMissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionCommandController {

    private final MissionCommandService missionCommandService;
    private final UserMissionCommandService userMissionCommandService;

    /**
     * 가게에 미션 추가하기
     */
    @PostMapping("/{storeId}")
    public ApiResponse<MissionCreateResponse> createMission(
            @PathVariable Long storeId,
            @RequestBody MissionCreateRequest request
    ) {
        MissionCreateResponse response = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, response);
    }

    /**
     * 미션 도전하기 (challenge)
     */
    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<UserMissionChallengeResponse> challengeMission(
            @PathVariable Long storeId,
            @PathVariable Long missionId
    ) {
        UserMissionChallengeResponse response =
                userMissionCommandService.requestMission(storeId, missionId);

        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, response);
    }
}


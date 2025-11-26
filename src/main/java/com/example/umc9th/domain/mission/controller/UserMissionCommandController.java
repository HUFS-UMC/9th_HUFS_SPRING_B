package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;
import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import com.example.umc9th.domain.mission.exception.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.UserMissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.resolver.PositivePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserMissionCommandController {

    private final UserMissionCommandService userMissionCommandService;

    /**
     * 미션 신청 (challenge)
     */
    @Operation(summary = "미션 신청", description = "사용자가 특정 가게의 미션을 신청합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 신청 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 가게의 미션을 찾을 수 없음")
    })
    @PostMapping("/stores/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<UserMissionChallengeResponse> challengeMission(
            @PathVariable Long storeId,
            @PathVariable Long missionId
    ) {
        return ApiResponse.onSuccess(
                MissionSuccessCode.MISSION_REQUESTED,
                userMissionCommandService.requestMission(storeId, missionId)
        );
    }

    /**
     * 미션 완료 처리 + 이후 진행중인 미션 목록 반환
     */
    @Operation(summary = "미션 완료 처리", description = "미션 상태를 완료로 변경하고, 변경 후 사용자의 진행 중인 미션 목록을 페이징으로 반환합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 완료 처리 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "이미 완료된 미션"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "사용자의 미션이 아님"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저 미션 정보 찾을 수 없음")
    })
    @PatchMapping("/users/{userId}/missions/{userMissionId}/complete")
    public ApiResponse<Page<UserMissionProgressResponse>> completeMission(
            @PathVariable Long userId,
            @PathVariable Long userMissionId,
            @PositivePage Integer page
    ) {
        Page<UserMissionProgressResponse> result =
                userMissionCommandService.completeMission(userId, userMissionId, page);

        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_COMPLETED, result);
    }
}

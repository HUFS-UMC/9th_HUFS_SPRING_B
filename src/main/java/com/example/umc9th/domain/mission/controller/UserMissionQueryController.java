package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import com.example.umc9th.domain.mission.exception.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.resolver.PositivePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserMissionQueryController {

    private final MissionQueryService missionQueryService;

    @Operation(summary = "진행중인 미션 조회 API", description = "userId 기준으로 유저가 진행중인 미션을 페이징 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저 없음")
    })
    @GetMapping("/{userId}/missions/progress")
    public ApiResponse<Page<UserMissionProgressResponse>> getMyMissionProgress(
            @PathVariable Long userId,
            @PositivePage Integer page     // 🔥 RequestParam 대신 여기에 적용!
    ) {
        Page<UserMissionProgressResponse> result =
                missionQueryService.getMyMissionInProgress(userId, page);

        return ApiResponse.onSuccess(MissionSuccessCode.FOUND_IN_PROGRESS_MISSIONS, result);
    }
}

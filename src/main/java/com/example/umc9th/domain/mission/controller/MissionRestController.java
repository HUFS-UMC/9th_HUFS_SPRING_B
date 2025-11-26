package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.exception.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionQueryService missionQueryService;


    @Operation(
            summary = "특정 가게 미션 목록 조회 API",
            description = "storeId 기준으로 해당 가게의 미션을 10개씩 페이징 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게 없음")
    })
    @GetMapping("/{storeId}/missions")
    public ApiResponse<Page<MissionListResponse>> getStoreMissions(
            @PathVariable Long storeId,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        Page<MissionListResponse> result =
                missionQueryService.getMissionListByStore(storeId, page);

        return ApiResponse.onSuccess(MissionSuccessCode.FOUND_MISSIONS, result);
    }


}


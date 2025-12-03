package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<MissionListResponse> getMissionListByRegion(String regionName, Integer page);
    Page<MissionListResponse> getMissionListByStore(Long storeId, Integer page);
    
    // 내가 진행중인 미션 목록
    Page<UserMissionProgressResponse> getMyMissionInProgress(Long userId, Integer page);

}

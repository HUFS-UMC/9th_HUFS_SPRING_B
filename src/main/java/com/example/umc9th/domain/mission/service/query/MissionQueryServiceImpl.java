package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.store.exception.StoreErrorCode;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserMissionRepository userMissionRepository;

    private PageRequest toPageable(Integer page) {
        return PageRequest.of(page - 1, 10);
    }

    /** 지역 기반 미션 조회 */
    @Override
    public Page<MissionListResponse> getMissionListByRegion(String regionName, Integer page) {
        return missionRepository.findMissionsByRegion(regionName, toPageable(page));
    }

    /** 가게 기반 미션 조회 */
    @Override
    public Page<MissionListResponse> getMissionListByStore(Long storeId, Integer page) {
        if (!storeRepository.existsById(storeId)) {
            throw new StoreException(StoreErrorCode.NOT_FOUND);
        }
        return missionRepository.findMissionsByStoreId(storeId, toPageable(page));
    }

    /** 유저 진행중 미션 조회 */
    @Override
    public Page<UserMissionProgressResponse> getMyMissionInProgress(Long userId, Integer page) {
        return userMissionRepository.findUserMissionInProgress(userId, toPageable(page));
    }
}



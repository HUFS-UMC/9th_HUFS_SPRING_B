package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MissionCreateRequest;
import com.example.umc9th.domain.mission.dto.MissionCreateResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionCreateResponse createMission(Long storeId, MissionCreateRequest request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = Mission.builder()
                .title(request.getTitle())
                .rewardPoint(request.getRewardPoint())
                .store(store)
                .build();

        Mission saved = missionRepository.save(mission);

        return MissionCreateResponse.builder()
                .missionId(saved.getId())
                .storeId(storeId)
                .title(saved.getTitle())
                .rewardPoint(saved.getRewardPoint())
                .build();
    }
}

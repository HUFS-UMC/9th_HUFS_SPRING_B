package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.UserMissionChallengeRequest;
import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    @Override
    public UserMissionChallengeResponse requestMission(Long storeId, UserMissionChallengeRequest request) {

        // 로그인 없으므로 하드코딩
        Long hardUserId = 1L;
        User user = userRepository.findById(hardUserId)
                .orElseThrow();

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow();

        // Mission이 이 store 소속인지 체크
        if (!mission.getStore().getId().equals(storeId)) {
            throw new RuntimeException("해당 가게의 미션이 아닙니다.");
        }

        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.REQUESTED)
                .requestedAt(LocalDateTime.now())
                .build();

        UserMission saved = userMissionRepository.save(userMission);

        return UserMissionChallengeResponse.builder()
                .userMissionId(saved.getId())
                .missionId(mission.getId())
                .userId(user.getId())
                .status(saved.getStatus().name())
                .build();
    }
}

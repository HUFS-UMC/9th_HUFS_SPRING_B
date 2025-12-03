package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.UserMissionChallengeResponse;
import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.exception.MissionErrorCode;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    /** 미션 신청 */
    @Override
    public UserMissionChallengeResponse requestMission(Long storeId, Long missionId) {

        Long hardUserId = 1L;
        User user = userRepository.findById(hardUserId)
                .orElseThrow();

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow();

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

    /** 미션 완료 + 완료 후 진행중 미션 목록 반환 */
    @Transactional
    @Override
    public Page<UserMissionProgressResponse> completeMission(Long userId, Long userMissionId, Integer page) {

        UserMission userMission = userMissionRepository.findById(userMissionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND_USER_MISSION));

        if (!userMission.getUser().getId().equals(userId)) {
            throw new MissionException(MissionErrorCode.USER_MISSION_NOT_OWNED);
        }

        if (userMission.getStatus() == MissionStatus.COMPLETED) {
            throw new MissionException(MissionErrorCode.ALREADY_COMPLETED);
        }

        userMission.updateStatus(MissionStatus.COMPLETED);
        userMission.setCompletedAt(LocalDateTime.now());

        PageRequest pageable = PageRequest.of(page - 1, 10);
        return userMissionRepository.findUserMissionInProgress(userId, pageable);
    }
}

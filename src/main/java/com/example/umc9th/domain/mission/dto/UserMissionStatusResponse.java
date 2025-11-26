package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus; // 존재한다면 import
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // JPA 직렬화용
public class UserMissionStatusResponse {

    private Integer rewardPoint;
    private String storeName;
    private MissionStatus status;

    // JPQL new 연산자에 맞는 생성자
    public UserMissionStatusResponse(Integer rewardPoint, String storeName, MissionStatus status) {
        this.rewardPoint = rewardPoint;
        this.storeName = storeName;
        this.status = status;
    }
}

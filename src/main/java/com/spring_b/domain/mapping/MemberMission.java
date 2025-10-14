package com.spring_b.domain.mapping;

import com.spring_b.domain.common.BaseEntity;
import com.spring_b.domain.member.entity.Member;
import com.spring_b.domain.mission.entity.Mission;
import com.spring_b.domain.mission.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}

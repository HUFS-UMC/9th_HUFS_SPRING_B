package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.UserMissionProgressResponse;
import com.example.umc9th.domain.mission.dto.UserMissionStatusResponse;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("SELECT new com.example.umc9th.domain.mission.dto.UserMissionResponse(" +
            "m.rewardPoint, s.name, um.status) " +
            "FROM UserMission um " +
            "JOIN um.mission m " +
            "JOIN m.store s " +
            "WHERE um.user.id = :userId " +
            "ORDER BY um.mission.id DESC")
    Page<UserMissionStatusResponse> findUserMissions(@Param("userId") Long userId, Pageable pageable);

    @Query("""
       SELECT new com.example.umc9th.domain.mission.dto.UserMissionProgressResponse(
            m.id, m.title, m.rewardPoint, s.name, um.status, um.requestedAt
       )
       FROM UserMission um
       JOIN um.mission m
       JOIN m.store s
       WHERE um.user.id = :userId
       AND um.status IN (com.example.umc9th.domain.mission.enums.MissionStatus.REQUESTED,
                         com.example.umc9th.domain.mission.enums.MissionStatus.IN_PROGRESS)
       ORDER BY um.requestedAt DESC
       """)
    Page<UserMissionProgressResponse> findUserMissionInProgress(
            @Param("userId") Long userId,
            Pageable pageable
    );

}

package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.UserMissionResponse;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("SELECT new com.example.umc9th.domain.mission.dto.UserMissionResponse(" +
            "um.price, um.point, s.name) " +
            "FROM UserMission um " +
            "JOIN um.mission m " +
            "JOIN m.store s " +
            "WHERE um.user.id = :userId " +
            "ORDER BY um.mission.id DESC")
    Page<UserMissionResponse> findUserMissions(@Param("userId") Long userId, Pageable pageable);
}

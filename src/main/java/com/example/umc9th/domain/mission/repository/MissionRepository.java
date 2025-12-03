package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
       SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
              m.id, m.title, m.rewardPoint, s.name, s.address)
       FROM Mission m
       JOIN m.store s
       WHERE s.region = :regionName
       ORDER BY m.createdAt DESC
       """)
    Page<MissionListResponse> findMissionsByRegion(
            @Param("regionName") String regionName,
            Pageable pageable
    );

    @Query("""
       SELECT new com.example.umc9th.domain.mission.dto.MissionListResponse(
              m.id, m.title, m.rewardPoint, s.name, s.address)
       FROM Mission m
       JOIN m.store s
       WHERE s.id = :storeId
       ORDER BY m.createdAt DESC
       """)
    Page<MissionListResponse> findMissionsByStoreId(
            @Param("storeId") Long storeId,
            Pageable pageable
    );
}

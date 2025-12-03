package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.dto.UserPointResponse;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.umc9th.domain.user.dto.UserPointResponse(" +
            "u.name, u.email, u.phoneNumber, COALESCE(SUM(ph.amountPoint), 0)) " +
            "FROM User u LEFT JOIN PointHistory ph ON u.id = ph.user.id " +
            "WHERE u.id = :userId GROUP BY u.id")
    UserPointResponse findUserPointInfo(@Param("userId") Long userId);

    //  로그인용
    Optional<User> findByEmail(String email);
}

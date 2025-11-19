package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.mapping.PreferredFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferredFoodRepository extends JpaRepository<PreferredFood, Long> { }

package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.UserSignUpRequest;
import com.example.umc9th.domain.user.dto.UserSignUpResponse;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.PreferredFood;
import com.example.umc9th.domain.user.exception.FoodErrorCode;
import com.example.umc9th.domain.user.exception.FoodException;
import com.example.umc9th.domain.user.repository.FoodRepository;
import com.example.umc9th.domain.user.repository.PreferredFoodRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final PreferredFoodRepository preferredFoodRepository;

    @Override
    @Transactional
    public UserSignUpResponse signUp(UserSignUpRequest dto) {

        // 1. User 저장
        User user = UserConverter.toUser(dto);
        userRepository.save(user);

        // 2. 선호 음식 설정
        if (dto.preferFoods() != null && !dto.preferFoods().isEmpty()) {

            List<PreferredFood> preferredFoods = dto.preferFoods().stream()
                    .map(foodId -> {

                        Food food = foodRepository.findById(foodId)
                                .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));

                        PreferredFood pf = new PreferredFood(user, food);

                        // 양방향 연관관계 세팅
                        user.addPreferredFood(pf);

                        return pf;
                    })
                    .toList();

            preferredFoodRepository.saveAll(preferredFoods);
        }

        // 3. 응답 생성
        return UserConverter.toSignUpDTO(user);
    }
}

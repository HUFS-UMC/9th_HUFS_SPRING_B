package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.demo.domain.food.Food;

public interface FoodRepository extends JpaRepository<Food,Long> {
}

package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.demo.domain.member.MemberFood;

public interface MemberFoodRepository extends JpaRepository<MemberFood,Long> {
}

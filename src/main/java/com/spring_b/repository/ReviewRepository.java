package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.demo.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

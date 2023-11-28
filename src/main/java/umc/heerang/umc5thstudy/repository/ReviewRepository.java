package umc.heerang.umc5thstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

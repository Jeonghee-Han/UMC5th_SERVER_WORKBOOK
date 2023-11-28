package umc.heerang.umc5thstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}

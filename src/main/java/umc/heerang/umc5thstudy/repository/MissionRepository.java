package umc.heerang.umc5thstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}

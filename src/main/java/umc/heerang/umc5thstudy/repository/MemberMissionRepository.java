package umc.heerang.umc5thstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}

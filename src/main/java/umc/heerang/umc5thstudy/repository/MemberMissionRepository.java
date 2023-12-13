package umc.heerang.umc5thstudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.enums.MissionStatus;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}

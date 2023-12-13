package umc.heerang.umc5thstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

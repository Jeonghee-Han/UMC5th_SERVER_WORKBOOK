package umc.heerang.umc5thstudy.service.MemberService;

import umc.heerang.umc5thstudy.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
}

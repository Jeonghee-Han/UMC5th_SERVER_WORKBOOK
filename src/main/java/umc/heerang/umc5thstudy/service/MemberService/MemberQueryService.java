package umc.heerang.umc5thstudy.service.MemberService;

import org.springframework.data.domain.Page;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Review;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    Page<Review> getReviewList(Long memberId, Integer page);
}

package umc.heerang.umc5thstudy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.repository.MemberMissionRepository;
import umc.heerang.umc5thstudy.repository.MemberRepository;
import umc.heerang.umc5thstudy.repository.MissionRepository;
import umc.heerang.umc5thstudy.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> MemberReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberReviewPage;
    }

    @Override
    public Page<MemberMission> getMissionList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> MemberMissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberMissionPage;
    }
}
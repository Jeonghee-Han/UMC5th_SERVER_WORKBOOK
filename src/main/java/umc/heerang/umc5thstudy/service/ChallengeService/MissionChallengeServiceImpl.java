package umc.heerang.umc5thstudy.service.ChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.heerang.umc5thstudy.base.code.status.ErrorStatus;
import umc.heerang.umc5thstudy.base.exception.handler.MemberHandler;
import umc.heerang.umc5thstudy.base.exception.handler.MissionHandler;
import umc.heerang.umc5thstudy.converter.MemberMissionConverter;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.repository.MemberMissionRepository;
import umc.heerang.umc5thstudy.repository.MemberRepository;
import umc.heerang.umc5thstudy.repository.MissionRepository;
import umc.heerang.umc5thstudy.web.dto.MissionChallengeRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionChallengeServiceImpl implements MissionChallengeService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission challenge(MissionChallengeRequestDTO.ChallengeDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission memberMission = MemberMissionConverter.toChallenge(member, mission);
        return memberMissionRepository.save(memberMission);
    }
}

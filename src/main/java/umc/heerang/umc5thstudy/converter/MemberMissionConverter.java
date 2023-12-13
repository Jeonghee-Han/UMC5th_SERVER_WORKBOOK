package umc.heerang.umc5thstudy.converter;

import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.enums.MissionStatus;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.web.dto.MissionChallengeResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toChallenge(Member member, Mission mission) {

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionChallengeResponseDTO.ChallengeResultDto toChallengeResultDTO(MemberMission memberMission){
        return MissionChallengeResponseDTO.ChallengeResultDto
                .builder()
                .challengeId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

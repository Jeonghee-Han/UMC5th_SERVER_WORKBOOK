package umc.heerang.umc5thstudy.service.ChallengeService;

import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.web.dto.MissionChallengeRequestDTO;

public interface MissionChallengeService {
    MemberMission challenge(MissionChallengeRequestDTO.ChallengeDto form);
}

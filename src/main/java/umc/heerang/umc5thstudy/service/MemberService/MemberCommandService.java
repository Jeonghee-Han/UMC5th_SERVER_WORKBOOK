package umc.heerang.umc5thstudy.service.MemberService;

import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.web.dto.MemberRequestDTO;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}

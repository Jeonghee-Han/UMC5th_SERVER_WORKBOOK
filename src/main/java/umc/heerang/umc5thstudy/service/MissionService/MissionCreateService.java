package umc.heerang.umc5thstudy.service.MissionService;

import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.web.dto.MissionRequestDTO;

public interface MissionCreateService {
    Mission createMission(MissionRequestDTO.MissionDTO form);
}

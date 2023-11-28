package umc.heerang.umc5thstudy.converter;

import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.Store;
import umc.heerang.umc5thstudy.web.dto.MissionRequestDTO;
import umc.heerang.umc5thstudy.web.dto.MissionResponseDTO;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;
import umc.heerang.umc5thstudy.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.MissionDTO form, Store store) {
        return Mission.builder()
                .reward(form.getReward())
                .deadline(form.getDeadline())
                .missionSpec(form.getMissionSpec())
                .store(store)
                .build();
    }
    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

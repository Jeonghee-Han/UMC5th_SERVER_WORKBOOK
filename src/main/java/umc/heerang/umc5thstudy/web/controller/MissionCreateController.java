package umc.heerang.umc5thstudy.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.heerang.umc5thstudy.base.ApiResponse;
import umc.heerang.umc5thstudy.converter.MissionConverter;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.service.MissionService.MissionCreateService;
import umc.heerang.umc5thstudy.web.dto.MissionRequestDTO;
import umc.heerang.umc5thstudy.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionCreateController {
    private final MissionCreateService missionCreateService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> create(@RequestBody @Valid MissionRequestDTO.MissionDTO form){
        Mission mission = missionCreateService.createMission(form);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
}

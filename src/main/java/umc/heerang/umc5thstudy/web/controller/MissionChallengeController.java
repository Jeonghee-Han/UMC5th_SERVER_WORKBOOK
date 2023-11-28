package umc.heerang.umc5thstudy.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.heerang.umc5thstudy.base.ApiResponse;
import umc.heerang.umc5thstudy.converter.MemberMissionConverter;
import umc.heerang.umc5thstudy.converter.MissionConverter;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.mapping.MemberMission;
import umc.heerang.umc5thstudy.service.ChallengeService.MissionChallengeService;
import umc.heerang.umc5thstudy.web.dto.MissionChallengeRequestDTO;
import umc.heerang.umc5thstudy.web.dto.MissionChallengeResponseDTO;
import umc.heerang.umc5thstudy.web.dto.MissionRequestDTO;
import umc.heerang.umc5thstudy.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/challenges")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;

    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResponseDTO.ChallengeResultDto> challenge(@RequestBody @Valid MissionChallengeRequestDTO.ChallengeDto form) {
        MemberMission challenge = missionChallengeService.challenge(form);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(challenge));
    }
}

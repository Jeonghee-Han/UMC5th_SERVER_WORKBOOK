package umc.heerang.umc5thstudy.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class MissionChallengeRequestDTO {
    @Getter
    public static class ChallengeDto{
        @NotNull
        Long missionId;
        @NotNull
        Long memberId;
    }
}

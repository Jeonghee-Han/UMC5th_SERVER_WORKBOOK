package umc.heerang.umc5thstudy.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionDTO{
        @NotNull
        Integer reward;
        @NotNull
        Long storeId;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}

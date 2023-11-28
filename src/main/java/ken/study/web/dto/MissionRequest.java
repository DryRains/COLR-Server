package ken.study.web.dto;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MissionRequest {
    @Getter
    public static class CreateMissionDto {
        @NotBlank
        private String content;
        @NotNull
        @Min(0)
        private Integer price;
        @NotNull
        @Min(0)
        private Integer reward;
    }
}

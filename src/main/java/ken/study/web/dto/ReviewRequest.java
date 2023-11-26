package ken.study.web.dto;

import lombok.Getter;

import javax.validation.constraints.*;

public class ReviewRequest {

    @Getter
    public static class CreateReviewDTO {
        @Min(0)
        @Max(5)
        private Integer grade;
        @NotBlank
        @Size(min=1, max=200)
        private String content;
    }
}

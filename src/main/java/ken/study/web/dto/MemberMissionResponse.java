package ken.study.web.dto;

import ken.study.domain.common.status.MemberMissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcceptMissionResultDTO {
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}

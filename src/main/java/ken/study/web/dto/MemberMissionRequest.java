package ken.study.web.dto;

import ken.study.validation.annotation.ActiveMission;
import lombok.Getter;

public class MemberMissionRequest {
    @Getter
    public static class AcceptMissionDto {
        @ActiveMission
        Long missionId;
    }
}

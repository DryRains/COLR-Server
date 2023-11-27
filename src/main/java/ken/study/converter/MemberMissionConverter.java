package ken.study.converter;

import ken.study.domain.mapping.MemberMission;
import ken.study.web.dto.MemberMissionResponse;

public class MemberMissionConverter {

    public static MemberMissionResponse.AcceptMissionResultDTO toAcceptMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponse.AcceptMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}

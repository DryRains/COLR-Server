package ken.study.converter;

import ken.study.domain.Mission;
import ken.study.web.dto.MissionRequest;
import ken.study.web.dto.MissionResponse;

public class MissionConverter {

    public static MissionResponse.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponse.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequest.CreateMissionDto request){
        return Mission.builder()
                .content(request.getContent())
                .price(request.getPrice())
                .reward(request.getReward())
                .build();
    }
}

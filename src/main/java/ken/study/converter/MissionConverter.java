package ken.study.converter;

import ken.study.domain.Mission;
import ken.study.web.dto.MissionRequest;
import ken.study.web.dto.MissionResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponse.MissionPreviewDTO toMissionPreviewDTO(Mission mission){
        return MissionResponse.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .price(mission.getPrice())
                .reward(mission.getReward())
                .status(mission.getStatus())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponse.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionList){
        List<MissionResponse.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponse.MissionPreviewListDTO.builder()
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .missionPreviewList(missionPreviewDTOList)
                .build();
    }


}

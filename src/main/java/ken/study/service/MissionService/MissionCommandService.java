package ken.study.service.MissionService;

import ken.study.domain.Mission;
import ken.study.web.dto.MissionRequest;

public interface MissionCommandService {
    Mission createMission(Long restaurantId, String token, MissionRequest.CreateMissionDto request);
}

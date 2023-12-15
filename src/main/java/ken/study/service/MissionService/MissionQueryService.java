package ken.study.service.MissionService;

import ken.study.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Boolean checkActiveMission(Long missionId);

    Page<Mission> retrieveMissionList(Long restaurantId, int page);
}

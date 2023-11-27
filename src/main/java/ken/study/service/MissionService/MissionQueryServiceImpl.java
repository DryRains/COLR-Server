package ken.study.service.MissionService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MissionHandler;
import ken.study.domain.Mission;
import ken.study.domain.common.status.MissionStatus;
import ken.study.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    @Override
    public Boolean checkActiveMission(Long missionId) {
        return missionRepository.findById(missionId)
                .map(mission -> mission.getStatus().equals(MissionStatus.ACTIVE))
                .orElse(null);
    }
}

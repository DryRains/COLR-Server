package ken.study.service.MissionService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MissionHandler;
import ken.study.domain.Mission;
import ken.study.domain.Restaurant;
import ken.study.domain.common.status.MissionStatus;
import ken.study.repository.MissionRepository;
import ken.study.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Boolean checkActiveMission(Long missionId) {
        return missionRepository.findById(missionId)
                .map(mission -> mission.getStatus().equals(MissionStatus.ACTIVE))
                .orElse(null);
    }

    @Override
    public Page<Mission> retrieveMissionList(Long restaurantId, int page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return missionRepository.findAllByRestaurant(restaurant, pageable);
    }

}

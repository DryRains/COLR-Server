package ken.study.service.MissionService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.OwnerHandler;
import ken.study.apiPayload.exception.handler.RestaurantHandler;
import ken.study.converter.MissionConverter;
import ken.study.domain.Mission;
import ken.study.domain.Restaurant;
import ken.study.repository.MissionRepository;
import ken.study.repository.OwnerRepository;
import ken.study.repository.RestaurantRepository;
import ken.study.web.dto.MissionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final RestaurantRepository restaurantRepository;
    private final OwnerRepository ownerRepository;
    private final MissionRepository missionRepository;


    @Override
    @Transactional
    public Mission createMission(Long restaurantId, String token, MissionRequest.CreateMissionDto request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        //(임시) token -> restaurant's owner validation
        Long ownerId = Long.parseLong(token);
        Optional.of(restaurant.getOwner())
                .filter(owner -> owner.getId().equals(ownerId))
                .orElseThrow(() -> new OwnerHandler(ErrorStatus.OWNER_TOKEN_NOT_VALID));

        Mission mission = MissionConverter.toMission(request);
        mission.setRestaurant(restaurant);
        return missionRepository.save(mission);
    }
}

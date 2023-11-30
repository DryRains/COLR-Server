package ken.study.service.RestaurantService;

import ken.study.domain.Restaurant;
import ken.study.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Optional<Restaurant> findRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
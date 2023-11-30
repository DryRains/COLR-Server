package ken.study.service.RestaurantService;

import ken.study.domain.Restaurant;
import ken.study.repository.RestaurantRepository;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findRestaurant(Long restaurantId);
}

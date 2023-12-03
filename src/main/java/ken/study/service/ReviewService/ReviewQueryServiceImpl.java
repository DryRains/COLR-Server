package ken.study.service.ReviewService;

import ken.study.domain.Restaurant;
import ken.study.domain.Review;
import ken.study.repository.RestaurantRepository;
import ken.study.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> retrieveReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, pageable);
        return reviewPage;
    }
}

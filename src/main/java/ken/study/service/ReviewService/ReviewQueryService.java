package ken.study.service.ReviewService;

import ken.study.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {
    Page<Review> retrieveReviewList(Long restaurantId, Integer page);

    Page<Review> retrieveMyReviewList(String token, Integer page);
}

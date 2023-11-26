package ken.study.service.ReviewService;

import ken.study.domain.Review;
import ken.study.web.dto.ReviewRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewCommandService {
    Review createReview(Long restaurantId, String token, ReviewRequest.CreateReviewDTO request, List<MultipartFile> images);
}

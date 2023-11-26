package ken.study.converter;

import ken.study.domain.Review;
import ken.study.web.dto.ReviewRequest;
import ken.study.web.dto.ReviewResponse;

import java.util.ArrayList;


public class ReviewConverter {

    public static ReviewResponse.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return ReviewResponse.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequest.CreateReviewDTO request) {
        return Review.builder()
                .grade(request.getGrade())
                .content(request.getContent())
                .reviewPhotoList(new ArrayList<>())
                .build();
    }
}

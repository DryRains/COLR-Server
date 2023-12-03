package ken.study.converter;

import ken.study.domain.Review;
import ken.study.web.dto.ReviewRequest;
import ken.study.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ReviewConverter {

    public static ReviewResponse.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
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

    public static ReviewResponse.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return ReviewResponse.ReviewPreviewDTO.builder()
                .reviewId(review.getId())
                .writerNickname(review.getMember().getNickName())
                .grade(review.getGrade())
                .content(review.getContent())
                .reviewPhotoList(review.getReviewPhotoList())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponse.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {
        List<ReviewResponse.ReviewPreviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponse.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewPreviewList(reviewPreViewDTOList)
                .build();
    }
}

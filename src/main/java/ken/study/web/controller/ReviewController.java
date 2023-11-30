package ken.study.web.controller;

import com.google.common.net.HttpHeaders;
import ken.study.apiPayload.ApiResponse;
import ken.study.converter.ReviewConverter;
import ken.study.domain.Review;
import ken.study.service.ReviewService.ReviewCommandService;
import ken.study.validation.annotation.ExistRestaurant;
import ken.study.web.dto.ReviewRequest;
import ken.study.web.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ApiResponse<ReviewResponse.CreateReviewResultDTO> createReview(@ExistRestaurant @PathVariable("restaurantId") Long restaurantId,
                                                                          @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                          @RequestPart(value = "data") @Valid ReviewRequest.CreateReviewDTO request,
                                                                          @RequestPart(value = "image", required = false) List<MultipartFile> images)  {
        Review review = reviewCommandService.createReview(restaurantId, token, request, images);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}

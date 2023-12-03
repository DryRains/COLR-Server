package ken.study.web.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import ken.study.apiPayload.ApiResponse;
import ken.study.converter.ReviewConverter;
import ken.study.domain.Review;
import ken.study.service.ReviewService.ReviewCommandService;
import ken.study.service.ReviewService.ReviewQueryService;
import ken.study.validation.annotation.ExistRestaurant;
import ken.study.validation.annotation.ValidPageNumber;
import ken.study.web.dto.ReviewRequest;
import ken.study.web.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final ReviewQueryService reviewQueryService;

    @Operation(summary = "[회원] 특정 가게의 리뷰 작성", description = "회원이 특정 가게에 리뷰를 작성합니다.")
    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ApiResponse<ReviewResponse.CreateReviewResultDTO> createReview(@ExistRestaurant @PathVariable("restaurantId") Long restaurantId,
                                                                          @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                          @RequestPart(value = "data") @Valid ReviewRequest.CreateReviewDTO request,
                                                                          @RequestPart(value = "image", required = false) List<MultipartFile> images)  {
        Review review = reviewCommandService.createReview(restaurantId, token, request, images);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

    @Operation(summary = "[회원] 내가 작성한 리뷰 목록 조회", description = "현재 로그인한 회원의 리뷰 목록을 query string을 통해 요청한 페이지별로 조회합니다.")
    @GetMapping("/members/reviews")
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO> retrieveMyReviewList(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                                 @ValidPageNumber @RequestParam(value = "page", required = false) Integer page) {
        Page<Review> reviewList = reviewQueryService.retrieveMyReviewList(token, page-1);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewList));
    }


    @Operation(summary = "특정 가게의 리뷰 목록 조회", description = "특정 가게의 리뷰 목록을 query string을 통해 요청한 페이지별로 조회합니다.")
    @GetMapping("/restaurants/{restaurantId}/reviews")
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO> retrieveReviewList(@ExistRestaurant @PathVariable("restaurantId") Long restaurantId,
                                                                           @ValidPageNumber @RequestParam(value = "page", required = false) Integer page) {
        Page<Review> reviewList = reviewQueryService.retrieveReviewList(restaurantId, page-1);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewList));
    }

}

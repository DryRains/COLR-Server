package ken.study.service.ReviewService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MemberHandler;
import ken.study.apiPayload.exception.handler.RestaurantHandler;
import ken.study.converter.ReviewConverter;
import ken.study.domain.Member;
import ken.study.domain.Restaurant;
import ken.study.domain.Review;
import ken.study.repository.MemberRepository;
import ken.study.repository.RestaurantRepository;
import ken.study.repository.ReviewRepository;
import ken.study.web.dto.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public Review createReview(Long restaurantId, String token, ReviewRequest.CreateReviewDTO request, List<MultipartFile> images) {
        //(임시) token -> member validation
        Long memberId = Long.parseLong(token);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = ReviewConverter.toReview(request);
        review.setRestaurant(restaurantRepository.findById(restaurantId).get());
        review.setMember(member);

        //Todo : if requested images exist
        //Save to S3 logics

        return reviewRepository.save(review);
    }
}

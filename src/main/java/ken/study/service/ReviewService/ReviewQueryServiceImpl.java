package ken.study.service.ReviewService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MemberHandler;
import ken.study.domain.Member;
import ken.study.domain.Restaurant;
import ken.study.domain.Review;
import ken.study.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> retrieveMyReviewList(String token, Integer page) {
        //(임시) token -> restaurant's owner validation
        Long writerId = Long.parseLong(token);
        Member member = memberRepository.findById(writerId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Review> reviewPage = reviewRepository.findAllByMember(member, pageable);
        return reviewPage;
    }

    @Override
    public Page<Review> retrieveReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, pageable);
        return reviewPage;
    }


}

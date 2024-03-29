package ken.study.service.MemberService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.FoodHandler;
import ken.study.converter.MemberConverter;
import ken.study.converter.MemberFoodConverter;
import ken.study.domain.Food;
import ken.study.domain.Member;
import ken.study.domain.mapping.MemberFood;
import ken.study.repository.FoodRepository;
import ken.study.repository.MemberRepository;
import ken.study.web.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member signUpMember(MemberRequest.SignUpDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<Food> foodList = request.getPreferFoods().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFoodConverter.toMemberFoodList(foodList);

        memberFoodList.forEach(memberFood -> {memberFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}

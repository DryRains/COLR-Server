package ken.study.converter;

import ken.study.domain.Food;
import ken.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {
    public static List<MemberFood> toMemberFoodrList(List<Food> foodList) {

        return foodList.stream()
                .map(food ->
                        MemberFood.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}

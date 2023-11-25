package ken.study.service.FoodService;

import ken.study.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodQueryServiceImpl implements FoodQueryService {

    private final FoodRepository foodRepository;

    @Override
    public boolean checkFoodsExist(List<Long> foodIds) {
        return foodIds.stream().allMatch(id -> foodRepository.existsById(id));
    }
}

package ken.study.service.FoodService;

import java.util.List;

public interface FoodQueryService {
    boolean checkFoodsExist(List<Long> foodIds);
}

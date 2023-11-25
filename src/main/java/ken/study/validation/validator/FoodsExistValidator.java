package ken.study.validation.validator;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.service.FoodService.FoodQueryService;
import ken.study.validation.annotation.ExistFoods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodsExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodQueryService foodCategoryService;

    @Override
    public void initialize(ExistFoods constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryService.checkFoodsExist(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}

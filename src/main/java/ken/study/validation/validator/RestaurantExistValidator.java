package ken.study.validation.validator;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.domain.Restaurant;
import ken.study.service.RestaurantService.RestaurantQueryService;
import ken.study.validation.annotation.ExistRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantQueryService restaurantQueryService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Restaurant> target = restaurantQueryService.findRestaurant(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
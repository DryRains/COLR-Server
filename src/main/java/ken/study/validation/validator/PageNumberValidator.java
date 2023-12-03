package ken.study.validation.validator;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.validation.annotation.ValidPageNumber;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageNumberValidator implements ConstraintValidator<ValidPageNumber, Integer> {
    @Override
    public void initialize(ValidPageNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_QUERYSTRING_NOT_EXIST.toString()).addConstraintViolation();
            return false;
        }
        else if (value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_NOT_VALID.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}

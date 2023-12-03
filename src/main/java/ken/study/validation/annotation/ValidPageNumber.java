package ken.study.validation.annotation;

import ken.study.validation.validator.PageNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPageNumber {
    String message() default "유효한 페이지 번호가 아닙니다. 페이지 번호는 1부터 시작합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

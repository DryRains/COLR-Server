package ken.study.validation.validator;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.service.MissionService.MissionQueryService;
import ken.study.validation.annotation.ActiveMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionActiveValidator implements ConstraintValidator<ActiveMission, Long> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(ActiveMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Boolean isValid = missionQueryService.checkActiveMission(value);

        if (isValid == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_ACTIVE.toString()).addConstraintViolation();
        }

        return isValid;
    }
}

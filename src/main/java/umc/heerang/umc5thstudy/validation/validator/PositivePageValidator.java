package umc.heerang.umc5thstudy.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.heerang.umc5thstudy.base.code.status.ErrorStatus;
import umc.heerang.umc5thstudy.validation.annotation.PositivePage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PositivePageValidator implements ConstraintValidator<PositivePage, Integer> {
    @Override
    public void initialize(PositivePage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._PAGE_NUMBER_INVALID.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}

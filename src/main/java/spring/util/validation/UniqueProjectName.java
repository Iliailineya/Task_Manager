package spring.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueProjectNameValidation.class)
@Documented
public @interface UniqueProjectName {
    String message() default "is not unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
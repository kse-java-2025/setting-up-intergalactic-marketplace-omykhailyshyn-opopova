package com.example.demo.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IntergalacticCategoryNameValidator.class)
@Documented
public @interface ValidIntergalacticCategoryName {

    String message() default "Invalid category name. Must be one of the predefined intergalactic categories.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
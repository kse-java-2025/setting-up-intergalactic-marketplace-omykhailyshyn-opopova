package com.example.demo.dto.validation;

import com.example.demo.common.IntergalacticCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class IntergalacticCategoryNameValidator implements ConstraintValidator<ValidIntergalacticCategoryName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; 

        return Arrays.stream(IntergalacticCategory.values())
                .anyMatch(cat -> cat.name().equalsIgnoreCase(value.trim()));
    }
}
package com.example.demo.dto.category;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import com.example.demo.dto.validation.ValidIntergalacticCategoryName;
import com.example.demo.dto.validation.ExtendedValidation;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
@GroupSequence({ CategoryDto.class, ExtendedValidation.class })
public class CategoryDto {
    @NotNull(message = "Category ID is mandatory")
    UUID categoryId;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @ValidIntergalacticCategoryName(groups = ExtendedValidation.class)
    String categoryName;
}

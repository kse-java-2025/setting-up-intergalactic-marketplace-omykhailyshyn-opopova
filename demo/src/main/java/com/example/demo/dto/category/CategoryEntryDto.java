package com.example.demo.dto.category;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CategoryEntryDto {
    UUID categoryId;
    String categoryName;
}

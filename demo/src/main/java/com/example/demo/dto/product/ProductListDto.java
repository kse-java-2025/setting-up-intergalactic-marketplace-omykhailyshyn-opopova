package com.example.demo.dto.product;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class ProductListDto {
    int page;
    int size;
    int totalItems;
    int totalPages;
    List<ProductEntryDto> productEntries; 
}
package com.example.demo.dto.product;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ProductEntryDto {
    UUID productId;
    String productName;
    Double productPrice;
    UUID productCategoryId;
}
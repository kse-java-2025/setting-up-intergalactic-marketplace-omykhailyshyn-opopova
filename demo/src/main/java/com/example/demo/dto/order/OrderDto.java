package com.example.demo.dto.order;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;
import java.util.UUID;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import com.example.demo.dto.product.ProductDto;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderDto {
    @NotEmpty(message = "Product entries cannot be empty")
    @Valid
    List<ProductDto> productEntries;

    @NotNull(message = "Customer ID is mandatory")
    UUID customerId;
}

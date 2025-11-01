package com.example.demo.dto.cart;

import com.example.demo.dto.product.ProductDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class CartDto {
    @NotNull(message = "Customer ID must not be null")
    UUID customerId;

    @NotNull(message = "Product must not be null")
    ProductDto product;
}

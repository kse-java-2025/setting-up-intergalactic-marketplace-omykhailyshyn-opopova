package com.example.demo.dto.order;

import com.example.demo.dto.product.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderDto {

    @NotNull(message = "Product must not be null")
    @Valid
    ProductDto product;

    @NotNull(message = "Total price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total price must be greater than 0")
    Double totalPrice;

    @NotNull(message = "Customer ID must not be null")
    UUID customerId;
}

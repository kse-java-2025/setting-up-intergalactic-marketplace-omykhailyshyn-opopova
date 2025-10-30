package com.example.demo.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderDTO {
    @NotNull(message = "Product ID is mandatory")
    UUID productId; 

    @Min(value = 1, message = "Quantity must be at least 1")
    int quantity; 

    @NotNull(message = "Total price cannot be null")
    @Min(value = 0, message = "Total price must be positive")
    Double totalPrice; 
}

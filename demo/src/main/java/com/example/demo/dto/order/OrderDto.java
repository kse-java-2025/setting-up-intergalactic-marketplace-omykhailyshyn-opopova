package com.example.demo.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderDto {
    @NotEmpty(message = "Order must contain at least one product")
    @Valid
    List<OrderItemDto> productEntries;

    @NotNull(message = "Customer ID is mandatory")
    UUID customerId;
}

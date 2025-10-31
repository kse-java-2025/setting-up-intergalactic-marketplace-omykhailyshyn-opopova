package com.example.demo.dto.cart;

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
public class CartDto {

    @NotNull(message = "Customer ID is mandatory")
    UUID customerId;

    @NotEmpty(message = "Cart must contain at least one product")
    @Valid // for deep validation of each element in the collection
    List<CartItemDto> productEntries;
}

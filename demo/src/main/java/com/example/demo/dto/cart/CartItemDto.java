// DO I NEED IT? or i can just use ProductDto inside CartResponseDto?
// and if I still need it, do I have to add CartItem domain?

// package com.example.demo.dto.cart;

// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;
// import lombok.Builder;
// import lombok.Value;
// import lombok.extern.jackson.Jacksonized;
// import java.util.UUID;

// @Value
// @Builder(toBuilder = true)
// @Jacksonized
// public class CartItemDto {

//     @NotNull(message = "Product ID cannot be null")
//     UUID productId;

//     @Min(value = 1, message = "Quantity must be at least 1")
//     int quantity;
// }

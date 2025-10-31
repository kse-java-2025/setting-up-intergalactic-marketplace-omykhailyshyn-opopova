package com.example.demo.dto.cart;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;
import java.util.UUID;
import com.example.demo.dto.product.ProductDto;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class CartResponseDto {
    UUID cartId;
    List<ProductDto> productEntries;
    Double totalPrice;
    UUID customerId;
}

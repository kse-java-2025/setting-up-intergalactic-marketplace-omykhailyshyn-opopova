package com.example.demo.dto.cart;

import com.example.demo.dto.product.ProductEntryDto;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class CartEntryDto {
    UUID cartId;
    UUID customerId;
    ProductEntryDto product;
    Double totalPrice;
}

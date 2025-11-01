package com.example.demo.dto.cart;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class CartListDto {
    int page;
    int size;
    int totalCarts;
    int totalPages;
    List<CartEntryDto> carts;
}

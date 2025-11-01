package com.example.demo.dto.order;

import com.example.demo.dto.product.ProductEntryDto;
import com.example.demo.common.OrderStatus;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class OrderEntryDto {
    UUID orderId;
    ProductEntryDto product; // if list?
    Double totalPrice;
    OrderStatus orderStatus;
    UUID customerId;
}

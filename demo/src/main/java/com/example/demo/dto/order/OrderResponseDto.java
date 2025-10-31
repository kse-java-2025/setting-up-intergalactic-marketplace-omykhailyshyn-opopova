package com.example.demo.dto.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import java.util.List;
import com.example.demo.common.OrderStatus;
import com.example.demo.dto.product.ProductDto;

@Value
@Builder(toBuilder = true)
public class OrderResponseDto {
    UUID orderId;
    List<ProductDto> productEntries;
    Double totalPrice;
    OrderStatus orderStatus;
    UUID customerId;
}
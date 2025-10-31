package com.example.demo.dto.order;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;
import com.example.demo.dto.order.OrderResponseDto;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderListDto {
    List<OrderResponseDto> orders;
    int page;
    int size;
    int totalOrders;
    int totalPages;
}

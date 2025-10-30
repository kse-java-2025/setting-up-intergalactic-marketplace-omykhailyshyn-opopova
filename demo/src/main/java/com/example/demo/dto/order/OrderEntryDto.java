package com.example.demo.dto.order;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderEntryDto {
    UUID orderId;       
    UUID productId;     
    int quantity;       
    Double totalPrice;  
}

package com.example.demo.domain.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class OrderEntry {
    UUID productId;
    int quantity;
    Double price;
}

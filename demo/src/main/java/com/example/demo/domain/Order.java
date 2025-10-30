package com.example.demo.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Order {
    UUID orderId;              
    UUID productId;            
    int quantity;             
    Double totalPrice;        
}

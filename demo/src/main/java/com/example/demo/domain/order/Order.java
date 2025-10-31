package com.example.demo.domain.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import java.util.List;
import com.example.demo.common.OrderStatus;

@Value
@Builder(toBuilder = true)
public class Order {
    UUID orderId;              
    List<OrderEntry> orderEntries;            
    Double totalPrice;        
    OrderStatus orderStatus;
    UUID customerId;
}

package com.example.demo.domain.order;

import com.example.demo.domain.Product;
import com.example.demo.common.OrderStatus;
import lombok.Builder;
import lombok.Value;
import java.util.List;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Order {
    UUID orderId;              
    List<Product> productEntries;            
    Double totalPrice;        
    OrderStatus orderStatus;
    UUID customerId;

    // factory method to create Order from Cart
    // just use Order orderId is bad practice ?
    public static Order createOrderFromCart(UUID customerId, List<Product> productEntries, Double totalPrice) {
        return Order.builder()
                .orderId(UUID.randomUUID())
                .customerId(customerId)
                .productEntries(productEntries)
                .totalPrice(totalPrice)
                .orderStatus(OrderStatus.PENDING)
                .build();
    }
}

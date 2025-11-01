package com.example.demo.domain;

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
    //List<Product> productEntries;     
    Product product;       
    Double totalPrice;        
    OrderStatus orderStatus;
    UUID customerId;

    // factory method to create Order from Cart
    // just use Order orderId is bad practice ?
}

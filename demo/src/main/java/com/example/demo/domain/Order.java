package com.example.demo.domain.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import java.util.List;
import com.example.demo.common.OrderStatus;
import com.example.demo.domain.product.Product;

@Value
@Builder(toBuilder = true)
public class Order {
    UUID orderId;              
    List<Product> productEntries;            
    Double totalPrice;        
    OrderStatus orderStatus;
    UUID customerId;
}

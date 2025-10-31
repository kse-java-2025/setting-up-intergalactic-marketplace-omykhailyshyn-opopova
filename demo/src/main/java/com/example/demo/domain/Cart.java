package com.example.demo.domain.cart;

import lombok.Builder;
import lombok.Value;
import java.util.List;
import java.util.UUID;
import com.example.demo.domain.Product;

@Value
@Builder(toBuilder = true)
public class Cart {
    UUID cartId;
    List<Product> productEntries;
    Double totalPrice;
    UUID customerId;
}

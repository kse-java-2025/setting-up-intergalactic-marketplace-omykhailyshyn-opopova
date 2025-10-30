package com.example.demo.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Product {
    UUID ProductId;
    String ProductName;
    Double ProductPrice;
    String ProductCategory;

    public static Product create(String name, Double price, String category) {
        return Product.builder()
            .productId(UUID.randomUUID())
            .productName(name)
            .productPrice(price)
            .productCategory(category)
            .build();
    }
}

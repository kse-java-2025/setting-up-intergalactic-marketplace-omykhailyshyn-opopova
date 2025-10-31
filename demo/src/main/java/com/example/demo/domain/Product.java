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
    UUID ProductCategoryId;

    public static Product create(String name, Double price, UUID categoryId) {
        return Product.builder()
            .productId(UUID.randomUUID())
            .productName(name)
            .productPrice(price)
            .productCategoryId(categoryId)
            .build();
    }
}

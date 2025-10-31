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
}

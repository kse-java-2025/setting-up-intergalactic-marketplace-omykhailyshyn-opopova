package com.example.demo.domain;

import com.example.demo.domain.Product;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Category {
    UUID CategoryId;
    String CategoryName;
}

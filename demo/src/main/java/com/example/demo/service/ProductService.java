package com.example.demo.service;

import com.example.demo.domain.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts(String category, int page, int size);

    Product getProductById(UUID productId);

    Product updateProduct(Product product);

    void deleteProduct(UUID productId);
}

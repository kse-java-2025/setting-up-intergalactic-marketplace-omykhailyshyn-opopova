package com.example.demo.service.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Product with id %s not found";

    public ProductNotFoundException(String productId) {
        super(String.format(DEFAULT_MESSAGE, productId));
    }
}

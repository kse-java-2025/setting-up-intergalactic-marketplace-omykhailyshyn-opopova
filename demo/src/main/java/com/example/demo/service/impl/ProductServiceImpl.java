package com.example.demo.service.impl;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.exception.ProductNotFoundException;
import com.example.demo.service.exception.InternalServerErrorException;
import com.example.demo.service.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products = buildAllProductsMock();

    @Override
    public Product createProduct(Product product) {
        if (product == null) {
            throw new ValidationException("Product must not be null");
        }
        products.add(product);
        log.info("Product with id {} created", product.getProductId());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all products, total count: {}", products.size());
        return products;
    }

    @Override
    public Product getProductById(UUID productId) {
        if (productId == null) {
            throw new ValidationException("productId must not be null");
        }
        log.info("Fetching product with id {}", productId);
        try {
            return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId.toString()));
        } catch (ProductNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Unexpected error while fetching product {}", productId, ex);
            throw new InternalServerErrorException("Unexpected error while fetching product");
        }
    }

    private List<Product> buildAllProductsMock() {
        List<Product> mockProducts = new ArrayList<>();

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Anti-gravity yarn ball")
                .productPrice(10.0)
                .productCategoryId(UUID.randomUUID())
                .build());

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Cosmic milk")
                .productPrice(15.5)
                .productCategoryId(UUID.randomUUID())
                .build());

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Space catnip")
                .productPrice(20.99)
                .productCategoryId(UUID.randomUUID())
                .build());

        return mockProducts;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product == null) {
            throw new ValidationException("Product must not be null");
        }
        Product existingProduct = getProductById(product.getProductId());
        deleteProduct(existingProduct.getProductId());
        products.add(product);
        log.info("Product with id {} updated", product.getProductId());
        return product;
    }

    @Override
    public void deleteProduct(UUID productId) {
        if (productId == null) {
            throw new ValidationException("productId must not be null");
        }
        boolean removed = products.removeIf(p -> p.getProductId().equals(productId));
        if (!removed) {
            throw new ProductNotFoundException(productId.toString());
        }
        log.info("Product with id {} deleted", productId);
    }
}

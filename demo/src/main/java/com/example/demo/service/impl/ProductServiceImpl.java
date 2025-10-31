package com.example.demo.service.impl;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products = buildAllProductsMock();

    @Override
    public Product createProduct(Product product) {
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
        log.info("Fetching product with id {}", productId);
        return products.stream()
            .filter(product -> product.getProductId().equals(productId))
            .findFirst() // return Optional<Product>
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
        Product existingProduct = getProductById(product.getProductId());
        deleteProduct(existingProduct.getProductId());
        products.add(product);
        log.info("Product with id {} updated", product.getProductId());
        return product;
    }

    @Override
    public void deleteProduct(UUID productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        log.info("Product with id {} deleted", productId);
    }
}

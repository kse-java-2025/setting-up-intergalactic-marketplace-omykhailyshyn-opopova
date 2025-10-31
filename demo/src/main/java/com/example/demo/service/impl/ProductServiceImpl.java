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
    public List<Product> getAllProducts(UUID productCategoryId, int page, int size) {
        log.info("Fetching products - productCategoryId: {}, page: {}, size: {}", productCategoryId, page, size);
        
        List<Product> filteredProducts = products.stream()
            .filter(product -> product.getProductCategoryId().equals(productCategoryId))
            .toList();
        
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, filteredProducts.size());
        
        if (startIndex >= filteredProducts.size()) {
            log.warn("Requested page {} exceeds available data", page);
            return List.of();
        }
    
        List<Product> paginatedProducts = filteredProducts.subList(startIndex, endIndex);
        log.info("Returning {} products out of {} total", paginatedProducts.size(), filteredProducts.size());
        
        return paginatedProducts;
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
        
        UUID weaponCategoryId = UUID.fromString("1fa85f64-1234-4562-a3fc-2c963f66afb7");
        UUID foodCategoryId = UUID.fromString("1fa85f64-1234-4562-a3fc-2c963f66afb8");
        UUID toyCategoryId = UUID.fromString("1fa85f64-1234-4562-a3fc-2c963f66afb9");

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Anti-gravity yarn ball")
                .productPrice(10.0)
                .productCategoryId(weaponCategoryId)
                .build());

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Cosmic milk")
                .productPrice(15.5)
                .productCategoryId(foodCategoryId)
                .build());

        mockProducts.add(Product.builder()
                .productId(UUID.randomUUID())
                .productName("Space catnip")
                .productPrice(20.99)
                .productCategoryId(foodCategoryId)
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

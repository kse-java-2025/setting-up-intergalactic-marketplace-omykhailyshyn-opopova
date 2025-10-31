package com.example.demo.web;

import com.example.demo.domain.Product;
import com.example.demo.dto.product.ProductDto;
import com.example.demo.dto.product.ProductEntryDto;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntryDto>> getAllProducts() {
        List<ProductEntryDto> entries = productService.getAllProducts().stream()
                .map(this::toEntryDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(entries);
    }

    @PostMapping
    public ResponseEntity<ProductEntryDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        Product product = Product.builder()
                .productId(UUID.randomUUID())
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .productCategoryId(productDto.getProductCategoryId())
                .build();

        Product created = productService.createProduct(product);
        ProductEntryDto entry = toEntryDto(created);
        return ResponseEntity.created(URI.create("/v1/products/" + created.getProductId())).body(entry);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntryDto> getProductById(@PathVariable UUID productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(toEntryDto(product));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductEntryDto> updateProduct(@PathVariable UUID productId,
                                                         @Valid @RequestBody ProductDto productDto) {
        Product toUpdate = Product.builder()
                .productId(productId)
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .productCategoryId(productDto.getProductCategoryId())
                .build();

        Product updated = productService.updateProduct(toUpdate);
        return ResponseEntity.ok(toEntryDto(updated));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    private ProductEntryDto toEntryDto(Product p) {
        return ProductEntryDto.builder()
                .productId(p.getProductId())
                .productName(p.getProductName())
                .productPrice(p.getProductPrice())
                .productCategoryId(p.getProductCategoryId())
                .build();
    }
}

package com.example.demo.service.mapper;

import com.example.demo.domain.Product;
import com.example.demo.dto.product.ProductEntryDto;
import com.example.demo.dto.product.ProductListDto;
import com.example.demo.dto.product.ProductDto;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    @Mapping(target = "productId", expression = "java(UUID.randomUUID())")
    Product toProduct(ProductDto productDto);

    ProductEntryDto toProductEntryDto(Product product);

    default ProductListDto toProductListDto(List<Product> products, int page, int size, int totalItems, int totalPages) {
        List<ProductEntryDto> entries = products.stream()
                .map(this::toProductEntryDto)
                .toList();

        return ProductListDto.builder()
                .page(page)
                .size(size)
                .totalItems(totalItems)
                .totalPages(totalPages)
                .productEntries(entries)
                .build();
    }
}


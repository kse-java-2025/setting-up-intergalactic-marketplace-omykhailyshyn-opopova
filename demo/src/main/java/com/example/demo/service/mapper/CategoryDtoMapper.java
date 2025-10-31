package com.example.demo.service.mapper;

import com.example.demo.domain.Category;
import com.example.demo.dto.category.CategoryEntryDto;
import com.example.demo.dto.category.CategoryDto;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {
    @Mapping(target = "CategoryId", expression = "java(UUID.randomUUID())")
    Category toCategory(CategoryDto categoryDto);

    CategoryEntryDto toCategoryEntryDto(Category category);
}


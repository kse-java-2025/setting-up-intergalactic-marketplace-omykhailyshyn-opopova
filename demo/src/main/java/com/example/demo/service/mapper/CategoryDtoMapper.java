package com.example.demo.service.mapper;

import com.example.demo.domain.Category;
import com.example.demo.dto.category.CategoryEntryDto;
import com.example.demo.dto.category.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {
    Category toCategory(CategoryDto categoryDto);

    CategoryEntryDto toCategoryEntryDto(Category category);
}


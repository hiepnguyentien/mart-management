package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.entity.Categories;
import com.hiep.mart.domain.request.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Categories toCategory(CategoryRequest request);

    CategoryDTO toCategoryDTO(Categories categories);

    void updateCategory(@MappingTarget Categories categories, CategoryRequest request);
}

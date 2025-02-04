package com.hiep.mart.service;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.request.CategoryRequest;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    List<CategoryDTO> getAllActiveCategories();
    CategoryDTO getCategoryById(Long id, Locale locale);
    CategoryDTO createCategory(CategoryRequest request);
    CategoryDTO updateCategory(Long id, CategoryRequest request, Locale locale);
    void deleteCategory(Long categoryId, Locale locale);
    CategoryDTO inActivateCategory(Long categoryId, Locale locale);
    CategoryDTO activateCategory(Long categoryId, Locale locale);
}
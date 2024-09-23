package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.entity.Categories;
import com.hiep.mart.domain.mapper.CategoryMapper;
import com.hiep.mart.domain.request.CategoryRequest;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.CategoryRepository;
import com.hiep.mart.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    MessageSource messageSource;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId, Locale locale) {
        return categoryRepository.findById(categoryId)
                .map(categoryMapper::toCategoryDTO)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
    }

    @Override
    public CategoryDTO createCategory(CategoryRequest request) {
        Categories categories = categoryMapper.toCategory(request);
        categoryRepository.save(categories);
        return categoryMapper.toCategoryDTO(categories);
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryRequest request, Locale locale) {
        Categories categories = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        categoryMapper.updateCategory(categories, request);
        return categoryMapper.toCategoryDTO(categories);
    }

    @Override
    public void deleteCategory(Long categoryId, Locale locale) {
        Categories category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        categoryRepository.delete(category);
    }
}

package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.entity.Categories;
import com.hiep.mart.domain.mapper.CategoryMapper;
import com.hiep.mart.domain.request.CategoryRequest;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.CategoryRepository;
import com.hiep.mart.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('GET_ALL_CATEGORIES')")
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllActiveCategories() {
        return categoryRepository.findAll().stream()
                .filter(c -> c.getCategoryStatus().equals("ACTIVE"))
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
    @Transactional
    @PreAuthorize("hasAuthority('ADD_NEW_CATEGORY')")
    public CategoryDTO createCategory(CategoryRequest request) {
        Categories categories = categoryMapper.toCategory(request);
//        categories.setCategoryStatus("ACTIVE");
        categoryRepository.save(categories);
        return categoryMapper.toCategoryDTO(categories);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('UPDATE_CATEGORY')")
    public CategoryDTO updateCategory(Long categoryId, CategoryRequest request, Locale locale) {
        Categories categories = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        categoryMapper.updateCategory(categories, request);
        categoryRepository.save(categories);
        return categoryMapper.toCategoryDTO(categories);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    public void deleteCategory(Long categoryId, Locale locale) {
        Categories category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        categoryRepository.delete(category);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('INACTIVE_CATEGORY')")
    public CategoryDTO inActivateCategory(Long categoryId, Locale locale) {
        Categories categories = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        if(categories.getCategoryStatus().equals("INACTIVE")) {
            throw new AppException(ErrorCode.STATUS_ALREADY_INACTIVE, messageSource, locale);
        }
        categories.setCategoryStatus("INACTIVE");
        categoryRepository.save(categories);
        return categoryMapper.toCategoryDTO(categories);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('ACTIVE_CATEGORY')")
    public CategoryDTO activateCategory(Long categoryId, Locale locale) {
        Categories categories = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, messageSource, locale));
        if(categories.getCategoryStatus().equals("ACTIVE")) {
            throw new AppException(ErrorCode.STATUS_ALREADY_ACTIVE, messageSource, locale);
        }
        categories.setCategoryStatus("ACTIVE");
        categoryRepository.save(categories);
        return categoryMapper.toCategoryDTO(categories);
    }
}

package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.request.CategoryRequest;
import com.hiep.mart.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;

    @GetMapping("/find-all")
    public List<CategoryDTO> findAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/find-all-active")
    public List<CategoryDTO> findAllActive() {
        return categoryService.getAllActiveCategories();
    }

    @GetMapping("find-by-id/{id}")
    public CategoryDTO findById(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return categoryService.getCategoryById(id, locale);
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @PutMapping("{id}")
    public CategoryDTO update(@PathVariable Long id,
                              @RequestBody CategoryRequest request,
                              @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return categoryService.updateCategory(id, request, locale);
    }

    @PutMapping("/inactive/{id}")
    public CategoryDTO updateInactive(@PathVariable Long id,
                                      @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return categoryService.inActivateCategory(id, locale);
    }

    @PutMapping("/active/{id}")
    public CategoryDTO updateActive(@PathVariable Long id,
                                      @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return categoryService.activateCategory(id, locale);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id, @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        categoryService.deleteCategory(id, locale);
    }
}

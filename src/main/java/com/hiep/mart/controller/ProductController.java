package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.request.ProductRequest;
import com.hiep.mart.domain.response.ApiResponse;
import com.hiep.mart.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping("/find-all")
    public List<ProductDTO> findAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/find-by-id/{productId}")
    public ProductDTO findProductById(@PathVariable Long productId,
                                      @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return productService.getProductById(productId, locale);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> findProductByCategory(@PathVariable Long categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ProductDTO> findProductBySupplierId(@PathVariable Long supplierId){
        return productService.getProductsBySupplierId(supplierId);
    }

    @PostMapping
    public ApiResponse<ProductDTO> createProduct(@Valid @RequestBody ProductRequest request,
                                                 @RequestParam("file") MultipartFile file) throws IOException {
        ApiResponse<ProductDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(request, file));
        return apiResponse;
    }

    @PutMapping("/active/{id}")
    public ProductDTO activeProduct(@PathVariable Long id,
                                    @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return productService.activeProduct(id, locale);
    }

    @PutMapping("/inactive/{id}")
    public ProductDTO inActiveProduct(@PathVariable Long id,
                                    @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return productService.inActiveProduct(id, locale);
    }
}

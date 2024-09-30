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

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping("/find-all")
    public List<ProductDTO> findAllProduct(){
        return productService.getAllProducts();
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
    public ApiResponse<ProductDTO> createProduct(@Valid @RequestBody ProductRequest request){
        ApiResponse<ProductDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(request));
        return apiResponse;
    }



}

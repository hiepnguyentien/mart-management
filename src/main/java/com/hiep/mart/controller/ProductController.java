package com.hiep.mart.controller;

import com.hiep.mart.config.AppObjectMapper;
import com.hiep.mart.domain.dto.CartProductDTO;
import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.request.ProductRequest;
import com.hiep.mart.domain.response.ApiResponse;
import com.hiep.mart.service.ProductService;
import com.hiep.mart.service.impl.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(path = "/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;
    CloudinaryService cloudinaryService;
    AppObjectMapper appObjectMapper;

    @GetMapping("/find-all-active")
    public List<ProductDTO> findAllProduct(){
        return productService.getAllActiveProducts();
    }

    @GetMapping("/find-all")
    public List<ProductDTO> findAllActiveProducts() {
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

    @GetMapping("/find-by-name/{name}")
    public List<ProductDTO> findProductByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    @GetMapping("/find-all-by-user")
    public List<CartProductDTO> findAllProductByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        return productService.getAllProductsByUser(authorizationHeader);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(
            @RequestParam(value = "request") String request,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        ProductRequest productRequest = appObjectMapper.toPojo(request, ProductRequest.class);
        System.out.println(request);
        System.out.println(productRequest);

        String imageUrl = null;

        if (file != null && !file.isEmpty()) {
            Map<String, Object> uploadResult = cloudinaryService.uploadImage(file);
            imageUrl = uploadResult.get("url").toString();
            productRequest.setProductImage(imageUrl);
        }

        ProductDTO createdProduct = productService.createProduct(productRequest);

        ApiResponse<ProductDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdProduct);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/add-product-categoty/{categoryId}/{productId}")
    public void addProductCategory(@PathVariable Long categoryId,
                                   @PathVariable Long productId,
                                   @RequestParam(name = "lang", required = false) String lang) {
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        productService.addProductToCategory(categoryId, productId, locale);
    }

    @PutMapping("/update/{productId}")
    public ApiResponse<ProductDTO> updateProduct(@PathVariable Long productId,
                                                 @RequestBody ProductRequest request,
                                                 @RequestParam(name = "lang", required = false) String lang){
        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        ApiResponse<ProductDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, request, locale));
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

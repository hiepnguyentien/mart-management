package com.hiep.mart.service;

import java.util.List;
import java.util.Locale;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.request.ProductRequest;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id, Locale locale);
    List<ProductDTO> getProductsByName(String name, Locale locale);
    ProductDTO createProduct(ProductRequest request);
    ProductDTO updateProduct(Long id, ProductRequest request, Locale locale);
    void deleteProduct(Long id, Locale locale);

    List<ProductDTO> getProductsByCategoryId(Long categoryId);
    List<ProductDTO> getProductsBySupplierId(Long supplierId);
    List<ProductDTO> getProductsByBatchId(Long batchId);

    List<ProductDTO> getProductsByBrand(String brand);
    List<ProductDTO> getProductsByStatus(String status);
    List<ProductDTO> getProductsByPrice(Double price);
    List<ProductDTO> getProductsByInventoryQuantity(Long inventoryQuantity);
    List<ProductDTO> getProductsByName(String name);
    List<ProductDTO> getProductsByCode(String code);
    List<ProductDTO> getProductsByPromotion(double discountPercentage);
}

package com.hiep.mart.service;

import java.util.List;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.request.ProductRequest;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductRequest request);
    ProductDTO updateProduct(ProductRequest request);
    void deleteProduct(Long id);

    List<ProductDTO> getProductsByCategoryId(Long categoryId);
    List<ProductDTO> getProductsBySupplierId(Long supplierId);
    List<ProductDTO> getProductsByBatchId(Long batchId);

    List<ProductDTO> getProductsByBrand(String brand);
    List<ProductDTO> getProductsByStatus(String status);
    List<ProductDTO> getProductsByPrice(Double price);
    List<ProductDTO> getProductsByInventoryQuantity(Long inventoryQuantity);
    List<ProductDTO> getProductsByDescription(String description);
    List<ProductDTO> getProductsByName(String name);
    List<ProductDTO> getProductsByCode(String code);
}

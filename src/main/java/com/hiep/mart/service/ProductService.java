package com.hiep.mart.service;

import java.util.List;
import java.util.Locale;

import com.hiep.mart.domain.dto.CartProductDTO;
import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.request.ProductRequest;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    List<CartProductDTO> getAllProductsByUser(String authorizationHeader);
    List<ProductDTO> getAllActiveProducts();
    ProductDTO getProductById(Long id, Locale locale);
    List<ProductDTO> getProductsByName(String name);
    ProductDTO createProduct(ProductRequest request);
    ProductDTO updateProduct(Long id, ProductRequest request, Locale locale);
    void deleteProduct(Long id, Locale locale);
    ProductDTO inActiveProduct(Long id, Locale locale);
    ProductDTO activeProduct(Long id, Locale locale);
    void addProductToCategory(Long categoryId, Long productId, Locale locale);

    List<ProductDTO> getProductsByCategoryId(Long categoryId);
    List<ProductDTO> getProductsBySupplierId(Long supplierId);
    List<ProductDTO> getProductsByBatchId(Long batchId);

    List<ProductDTO> getProductsByBrand(String brand);
    List<ProductDTO> getProductsByStatus(String status);
    List<ProductDTO> getProductsByPrice(Double price);
    List<ProductDTO> getProductsByInventoryQuantity(Long inventoryQuantity);
    List<ProductDTO> getProductsByCode(String code);
    List<ProductDTO> getProductsByPromotion(Double discountPercentage);

    ProductDTO addProductToCart(Long productId, Long cartId, Locale locale);
    List<ProductDTO> getExpiredProducts();
    List<ProductDTO> getExpireIn7DaysProducts();
}

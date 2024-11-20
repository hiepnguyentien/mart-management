package com.hiep.mart.repository;

import com.hiep.mart.domain.dto.ProductDTO;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductDTO> getProductByCategoryId(Long categoryId);
    List<ProductDTO> getProductBySupplierId(Long supplierId);
    List<ProductDTO> getExpiredProducts();
    List<ProductDTO> getExpireIn7DaysProducts();
}

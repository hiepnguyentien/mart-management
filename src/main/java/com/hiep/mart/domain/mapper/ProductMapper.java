package com.hiep.mart.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.entity.Products;
import com.hiep.mart.domain.request.ProductRequest;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "supplierId", target = "suppliers.supplierId")
    Products toProducts(ProductRequest request);

    @Mapping(source = "suppliers.supplierId", target = "supplierId")
//    @Mapping(source = "suppliers.supplierName", target = "supplierName")
    ProductDTO toProductDTO(Products product);

    void updateProduct(@MappingTarget Products product, ProductRequest request);
}

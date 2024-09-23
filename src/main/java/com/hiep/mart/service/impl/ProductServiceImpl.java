package com.hiep.mart.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.hiep.mart.domain.entity.Products;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.context.MessageSource;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.mapper.ProductMapper;
import com.hiep.mart.domain.request.ProductRequest;
import com.hiep.mart.repository.ProductRepository;
import com.hiep.mart.service.ProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService{
    
    ProductRepository productRepository;
    ProductMapper productMapper;
    MessageSource messageSource;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id, Locale locale) {
        return productRepository.findById(id)
                .map(productMapper::toProductDTO)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));
    }

    @Override
    public List<ProductDTO> getProductsByName(String name, Locale locale) {
        return productRepository.findAll().stream()
                .filter(product -> product.getProductName().contains(name))
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDTO createProduct(ProductRequest request) {
        Products product = productMapper.toProducts(request);
        productRepository.save(product);
        return productMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductRequest request, Locale locale) {
        Products products = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));
        productMapper.updateProduct(products, request);

        productRepository.save(products);
        return productMapper.toProductDTO(products);
    }

    @Override
    public void deleteProduct(Long productId, Locale locale) {
        Products products = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));

        productRepository.delete(products);
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategoryId'");
    }

    @Override
    public List<ProductDTO> getProductsBySupplierId(Long supplierId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsBySupplierId'");
    }

    @Override
    public List<ProductDTO> getProductsByBatchId(Long batchId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBatchId'");
    }

    @Override
    public List<ProductDTO> getProductsByBrand(String brand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBrand'");
    }

    @Override
    public List<ProductDTO> getProductsByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByStatus'");
    }

    @Override
    public List<ProductDTO> getProductsByPrice(Double price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByPrice'");
    }

    @Override
    public List<ProductDTO> getProductsByInventoryQuantity(Long inventoryQuantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByInventoryQuantity'");
    }

    @Override
    public List<ProductDTO> getProductsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByName'");
    }

    @Override
    public List<ProductDTO> getProductsByCode(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCode'");
    }

    @Override
    public List<ProductDTO> getProductsByPromotion(double discountPercentage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByPromotion'");
    }
    
}

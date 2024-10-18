package com.hiep.mart.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.hiep.mart.domain.entity.Products;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.domain.mapper.ProductMapper;
import com.hiep.mart.domain.request.ProductRequest;
import com.hiep.mart.repository.ProductRepository;
import com.hiep.mart.service.ProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService{
    
    ProductRepository productRepository;
    ProductMapper productMapper;
    MessageSource messageSource;
    CloudinaryService cloudinaryService;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .filter(p -> p.getProductStatus().equals("Active"))
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ProductDTO> getAllProducts() {
//        return productRepository.findAll().stream()
//                .map(product -> {
//                    ProductDTO productDTO = productMapper.toProductDTO(product);
//                    String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                            .path("/images/")
//                            .path(product.getProductImage())
//                            .toUriString();
//                    productDTO.setProductImage(imageUrl);
//                    return productDTO;
//                })
//                .collect(Collectors.toList());
//    }


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
                .filter(p -> p.getProductStatus().equals("Active"))
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDTO createProduct(ProductRequest request, MultipartFile file) throws IOException {
        String imageUrl = (String) cloudinaryService.uploadImage(file).get("url");
        Products product = productMapper.toProducts(request);
        product.setProductImage(imageUrl);
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
    public ProductDTO inActiveProduct(Long productId, Locale locale) {
        Products products = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));
        if(products.getProductStatus().equals("Inactive")) {
            throw new AppException(ErrorCode.STATUS_ALREADY_INACTIVE, messageSource, locale);
        }
        products.setProductStatus("Inactive");
        productRepository.save(products);
        return productMapper.toProductDTO(products);
    }

    @Override
    public ProductDTO activeProduct(Long productId, Locale locale) {
        Products products = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));
        if(products.getProductStatus().equals("Active")) {
            throw new AppException(ErrorCode.STATUS_ALREADY_ACTIVE, messageSource, locale);
        }
        products.setProductStatus("Active");
        productRepository.save(products);
        return productMapper.toProductDTO(products);
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(Long categoryId) {
        return productRepository.getProductByCategoryId(categoryId);
    }

    @Override
    public List<ProductDTO> getProductsBySupplierId(Long supplierId) {
        return productRepository.getProductBySupplierId(supplierId);
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
    public List<ProductDTO> getProductsByCode(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCode'");
    }

    @Override
    public List<ProductDTO> getProductsByPromotion(Double discountPercentage) {
        return List.of();
    }

    @Override
    public ProductDTO addProductToCart(Long productId, Long cartId, Locale locale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProductToCart'");
    }
    
}

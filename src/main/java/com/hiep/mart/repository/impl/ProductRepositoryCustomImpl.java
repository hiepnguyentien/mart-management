package com.hiep.mart.repository.impl;

import com.hiep.mart.domain.dto.CartProductDTO;
import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        StringBuilder sql = new StringBuilder("SELECT new com.hiep.mart.domain.dto.ProductDTO(\n" +
                "    p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription, \n" +
                "    p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId, \n" +
                "    p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)\n" +
                "FROM Products p\n" +
                "JOIN p.categories c \n" +
                "LEFT JOIN p.promotions p2\n" +
                "WHERE c.categoryId = :categoryId and p.productStatus = 'Active'\n");

        TypedQuery<ProductDTO> query = em.createQuery(sql.toString(), ProductDTO.class);
        query.setParameter("categoryId", categoryId);

        return query.getResultList();
    }

    @Override
    public List<ProductDTO> getProductBySupplierId(Long supplierId) {
        StringBuilder sql = new StringBuilder("SELECT new com.hiep.mart.domain.dto.ProductDTO(\n" +
                "    p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription, \n" +
                "    p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId, \n" +
                "    p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)\n" +
                "FROM Products p\n" +
                "LEFT JOIN p.promotions p2 \n" +
                "WHERE p.suppliers.supplierId = :supplierId\n");

        TypedQuery<ProductDTO> query = em.createQuery(sql.toString(), ProductDTO.class);
        query.setParameter("supplierId", supplierId);

        return query.getResultList();
    }

    @Override
    public List<ProductDTO> getExpiredProducts() {
        StringBuilder sql = new StringBuilder("SELECT new com.hiep.mart.domain.dto.ProductDTO(\n" +
                "    p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription, \n" +
                "    p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId, \n" +
                "    p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)\n" +
                "FROM Products p\n" +
                "LEFT JOIN p.promotions p2 \n" +
                "WHERE p.suppliers.supplierId = :supplierId\n");

        TypedQuery<ProductDTO> query = em.createQuery(sql.toString(), ProductDTO.class);

        return query.getResultList();
    }

    @Override
    public List<ProductDTO> getExpireIn7DaysProducts() {
        StringBuilder sql = new StringBuilder("SELECT new com.hiep.mart.domain.dto.ProductDTO(\n" +
                "    p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription, \n" +
                "    p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId, \n" +
                "    p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)\n" +
                "FROM Products p\n" +
                "LEFT JOIN p.promotions p2 \n" +
                "WHERE p.suppliers.supplierId = :supplierId\n");

        TypedQuery<ProductDTO> query = em.createQuery(sql.toString(), ProductDTO.class);

        return query.getResultList();
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        String sql = """
                SELECT new com.hiep.mart.domain.dto.ProductDTO(
                p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription,
                p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId,
                p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)
                FROM Products p
                LEFT JOIN p.promotions p2
                WHERE p.productId = :productId
                """;

        TypedQuery<ProductDTO> query = em.createQuery(sql, ProductDTO.class);
        query.setParameter("productId", productId);
        return query.getSingleResult();
    }

    @Override
    public List<ProductDTO> getAllActiveProduct() {
        String sql = """
                SELECT new com.hiep.mart.domain.dto.ProductDTO(
                p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription,
                p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId,
                p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)
                FROM Products p
                LEFT JOIN p.promotions p2
                WHERE p.productStatus = 'Active'
                """;
        TypedQuery<ProductDTO> query = em.createQuery(sql, ProductDTO.class);
        return query.getResultList();
    }

    @Override
    public List<CartProductDTO> getAllProductsByUser(Long userId) {
        String sql = """
            SELECT new com.hiep.mart.domain.dto.CartProductDTO(
                p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription,
                p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId,
                p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice,
                COALESCE(c.quantity, 0)
            )
            FROM Products p
            LEFT JOIN p.promotions p2
            LEFT JOIN Cart c ON c.products = p AND c.user.id = :userId
            WHERE p.productStatus = 'Active'
            """;
        TypedQuery<CartProductDTO> query = em.createQuery(sql, CartProductDTO.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<ProductDTO> getProductsByName(String productName) {
        String sql = """
        SELECT new com.hiep.mart.domain.dto.ProductDTO(
        p.productId, p.productCode, p.productName, p.productPrice, p.productUnit, p.productDescription,
        p.productImage, p.productStatus, p.productBrand, p.inventoryQuantity, p.suppliers.supplierId,
        p.information, p2.discountPercentage, p2.discountAmount, p.promotionalPrice)
        FROM Products p
        LEFT JOIN p.promotions p2
        WHERE p.productStatus = 'Active' AND LOWER(p.productName) LIKE CONCAT('%', :productName, '%')
        """;
        TypedQuery<ProductDTO> query = em.createQuery(sql, ProductDTO.class);
        query.setParameter("productName", productName);
        return query.getResultList();
    }

}
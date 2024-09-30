package com.hiep.mart.repository.impl;

import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
                "LEFT JOIN p.promotions p2 \n" +
                "WHERE c.categoryId = :categoryId\n");

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
}

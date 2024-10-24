package com.hiep.mart.repository.impl;

import com.hiep.mart.domain.dto.ProductCartDTO;
import com.hiep.mart.repository.CartRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CartRepositoryCustomImpl implements CartRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductCartDTO> viewCart(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT new com.hiep.mart.domain.dto.ProductCartDTO(\n" +
                "p.productId, p.productName, p.productUnit, p.productImage, \n" +
                "p.productStatus, p.productBrand, p.productPrice, p2.discountPercentage, p2.discountAmount,\n" +
                "p.promotionalPrice, c.quantity, c.user.userId)\n" +
                "    from Cart c\n" +
                "join Products p on c.products.productId = p.productId\n" +
                "LEFT JOIN p.promotions p2\n" +
                "where c.user.userId = :userId and p.productStatus = 'Active'\n");

        TypedQuery<ProductCartDTO> query = em.createQuery(sql.toString(), ProductCartDTO.class);
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}

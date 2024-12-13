package com.hiep.mart.repository.impl;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.dto.PurchasedProductDTO;
import com.hiep.mart.repository.OrderDetailRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderDetailRepositoryCustomImpl implements OrderDetailRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PurchasedProductDTO> findByCustomerId(Long customerId) {
        String sql = """
                SELECT new com.hiep.mart.domain.dto.PurchasedProductDTO(
                od.orderDetailQuantity, od.orderDetailPrice,
                o.orderId, p.productName, o.orderDate)
                FROM Customers c
                LEFT JOIN c.orders o
                LEFT JOIN o.orderDetail od
                LEFT JOIN od.products p
                WHERE c.customerId = :customerId
                """;
        TypedQuery<PurchasedProductDTO> query = em.createQuery(sql, PurchasedProductDTO.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}

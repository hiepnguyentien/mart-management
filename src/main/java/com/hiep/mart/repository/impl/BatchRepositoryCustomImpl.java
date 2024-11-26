package com.hiep.mart.repository.impl;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.dto.ProductDTO;
import com.hiep.mart.repository.BatchRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BatchRepositoryCustomImpl implements BatchRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BatchDTO> getExpiredProducts() {
        String sql = """
                SELECT new com.hiep.mart.domain.dto.BatchDTO(
                b.batchId, b.batchQuantity, b.batchPrice, b.importDate, b.expiredDate, b.batchStatus, b.products.productId)
                from Batch b
                where b.batchStatus = 'Active' and b.expiredDate < current_date
                """;
        TypedQuery<BatchDTO> query = em.createQuery(sql, BatchDTO.class);

        return query.getResultList();
    }

    @Override
    public List<BatchDTO> getExpireIn7DaysProducts() {
        LocalDate expireDate = LocalDate.now().plusDays(7);
        String sql = """
                SELECT new com.hiep.mart.domain.dto.BatchDTO(
                b.batchId, b.batchQuantity, b.batchPrice, b.importDate, b.expiredDate, b.batchStatus, b.products.productId)
                from Batch b
                where b.batchStatus = 'Active' and b.expiredDate < :expireDate
                """;
        TypedQuery<BatchDTO> query = em.createQuery(sql, BatchDTO.class);
        query.setParameter("expireDate", expireDate);


        return query.getResultList();
    }
}

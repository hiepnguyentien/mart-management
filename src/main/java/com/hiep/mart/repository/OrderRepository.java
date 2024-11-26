package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.Orders;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = Queries.FIND_BY_CUSTOMER_ID, nativeQuery = true)
    List<Orders> findByCustomerId(Long customerId);
}

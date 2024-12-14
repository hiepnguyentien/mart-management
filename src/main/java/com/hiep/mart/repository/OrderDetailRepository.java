package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>, OrderDetailRepositoryCustom{

    @Query(value = Queries.FIND_BY_ORDER_ID, nativeQuery = true)
    List<OrderDetail> findByOrderId(Long orderId);


}

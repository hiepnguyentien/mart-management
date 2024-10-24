package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.Cart;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>, CartRepositoryCustom{

    @Query(nativeQuery = true, value = Queries.GET_PRODUCT_QUANTITY_IN_CART_BY_USER)
    Long countByCustomerId(Long productId, Long userId);

    @Query(nativeQuery = true, value = Queries.FIND_CART_BY_USER_AND_PRODUCT)
    Optional<Cart> findByCustomerIdAndProductId(Long userId, Long productId);
}

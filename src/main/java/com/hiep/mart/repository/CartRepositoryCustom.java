package com.hiep.mart.repository;

import com.hiep.mart.domain.dto.ProductCartDTO;

import java.util.List;

public interface CartRepositoryCustom {
    List<ProductCartDTO> viewCart(Long userId);
}

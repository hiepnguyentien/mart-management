package com.hiep.mart.repository;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.dto.PurchasedProductDTO;

import java.util.List;

public interface OrderDetailRepositoryCustom {
    List<PurchasedProductDTO> findByCustomerId(Long customerId);
}

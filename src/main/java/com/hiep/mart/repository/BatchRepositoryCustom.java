package com.hiep.mart.repository;

import com.hiep.mart.domain.dto.BatchDTO;

import java.util.List;

public interface BatchRepositoryCustom {
    List<BatchDTO> getExpiredProducts();
    List<BatchDTO> getExpireIn7DaysProducts();
}

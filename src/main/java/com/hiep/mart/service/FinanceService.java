package com.hiep.mart.service;

import com.hiep.mart.domain.dto.FinanceDTO;
import com.hiep.mart.domain.request.FinanceRequest;

import java.util.List;

public interface FinanceService {
    List<FinanceDTO> findAllFinances();
    void addFinance(FinanceRequest request);
}

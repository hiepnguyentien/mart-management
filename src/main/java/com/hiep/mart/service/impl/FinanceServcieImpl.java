package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.FinanceDTO;
import com.hiep.mart.domain.entity.Finance;
import com.hiep.mart.domain.mapper.FinanceMapper;
import com.hiep.mart.domain.request.FinanceRequest;
import com.hiep.mart.repository.FinanceRepository;
import com.hiep.mart.service.FinanceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FinanceServcieImpl implements FinanceService {

    FinanceRepository financeRepository;
    FinanceMapper financeMapper;

    @Override
    public List<FinanceDTO> findAllFinances() {
        return financeRepository.findAll()
                .stream()
                .map(financeMapper::toFinanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addFinance(FinanceRequest request) {
        Finance finance = financeMapper.toFinance(request);
        financeRepository.save(finance);
    }
}

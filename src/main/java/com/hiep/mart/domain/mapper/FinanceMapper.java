package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.FinanceDTO;
import com.hiep.mart.domain.entity.Finance;
import com.hiep.mart.domain.request.FinanceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FinanceMapper {
    Finance toFinance(FinanceRequest financeRequest);
    FinanceDTO toFinanceDTO(Finance finance);
    void updateFinance(@MappingTarget Finance finance, FinanceRequest financeRequest);
}

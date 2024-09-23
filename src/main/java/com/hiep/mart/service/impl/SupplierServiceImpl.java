package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.SupplierDTO;
import com.hiep.mart.domain.entity.Suppliers;
import com.hiep.mart.domain.mapper.SupplierMapper;
import com.hiep.mart.domain.request.SupplierRequest;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.SupplierRepository;
import com.hiep.mart.service.SupplierService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;
    SupplierMapper supplierMapper;
    MessageSource messageSource;

    @Override
    public List<SupplierDTO> getSuppliers() {
        return supplierRepository.findAll().stream()
                .map(supplierMapper::toSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierDTO> getSuppliers(String name) {
        return supplierRepository.findAll().stream()
                .filter(supplier -> supplier.getSupplierName().contains(name))
                .map(supplierMapper::toSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO getSupplierById(Long id, Locale locale) {
        return supplierRepository.findById(id)
                .map(supplierMapper::toSupplierDTO)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND, messageSource, locale));
    }

    @Override
    public SupplierDTO createSupplier(SupplierRequest request) {
        Suppliers supplier = supplierMapper.toSupplier(request);
        supplierRepository.save(supplier);
        return supplierMapper.toSupplierDTO(supplier);
    }
}

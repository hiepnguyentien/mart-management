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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('GET_ALL_SUPPLIERS')")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .filter(s -> s.getSupplierStatus().equals("Active"))
                .map(supplierMapper::toSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('GET_SUPPLIER_BY_NAME')")
    public List<SupplierDTO> getSuppliersByName(String name) {
        return supplierRepository.findAll().stream()
                .filter(supplier -> supplier.getSupplierName().contains(name))
                .filter(s -> s.getSupplierStatus().equals("Active"))
                .map(supplierMapper::toSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('GET_SUPPLIER_BY_ID')")
    public SupplierDTO getSupplierById(Long id, Locale locale) {
        return supplierRepository.findById(id)
                .filter(supplier -> supplier.getSupplierStatus().equals("Active"))
                .map(supplierMapper::toSupplierDTO)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND, messageSource, locale));
    }

    @Override
    @PreAuthorize("hasAuthority('ADD_SUPPLIER')")
    public SupplierDTO addSupplier(SupplierRequest request) {
        Suppliers supplier = supplierMapper.toSupplier(request);
        supplierRepository.save(supplier);
        return supplierMapper.toSupplierDTO(supplier);
    }

    @Override
    @PreAuthorize("hasAuthority('DELETE_SUPPLIER')")
    public void deleteSupplier(Long id, Locale locale) {
        Suppliers suppliers = supplierRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND, messageSource, locale));
        if(suppliers.getSupplierStatus().equals("Active")) {
            throw new AppException(ErrorCode.SUPPLIER_ALREADY_INACTIVE, messageSource, locale);
        }
        suppliers.setSupplierStatus("Inactive");
    }
}

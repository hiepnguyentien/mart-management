package com.hiep.mart.service;

import com.hiep.mart.domain.dto.SupplierDTO;
import com.hiep.mart.domain.request.SupplierRequest;

import java.util.List;
import java.util.Locale;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    List<SupplierDTO> getSuppliersByName(String name);
    SupplierDTO getSupplierById(Long id, Locale locale);
    SupplierDTO addSupplier(SupplierRequest request);
    void deleteSupplier(Long id, Locale locale);
}

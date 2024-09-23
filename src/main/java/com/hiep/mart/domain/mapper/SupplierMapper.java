package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.SupplierDTO;
import com.hiep.mart.domain.entity.Suppliers;
import com.hiep.mart.domain.request.SupplierRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Suppliers toSupplier(SupplierRequest request);

    SupplierDTO toSupplierDTO(Suppliers suppliers);

    void updateSupplier(@MappingTarget Suppliers suppliers, SupplierRequest request);
}
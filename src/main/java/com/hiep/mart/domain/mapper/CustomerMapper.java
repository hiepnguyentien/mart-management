package com.hiep.mart.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.hiep.mart.domain.dto.CategoryDTO;
import com.hiep.mart.domain.dto.CustomerDTO;
import com.hiep.mart.domain.entity.Categories;
import com.hiep.mart.domain.entity.Customers;
import com.hiep.mart.domain.request.CategoryRequest;
import com.hiep.mart.domain.request.CustomerRequest;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customers toCustomer(CustomerRequest request);

    CustomerDTO toCustomerDTO(Customers customer);

    void updateCustomer(@MappingTarget Customers customer, CustomerRequest request);
}

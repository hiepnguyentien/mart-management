package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.EmployeeDTO;
import com.hiep.mart.domain.entity.Employees;
import com.hiep.mart.domain.request.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "shifts", ignore = true)
    Employees toEmployees(EmployeeRequest employeeRequest);
    EmployeeDTO toEmployeeDTO(Employees employees);
    void updateEmployees(@MappingTarget Employees employees, EmployeeRequest employeeRequest);
}

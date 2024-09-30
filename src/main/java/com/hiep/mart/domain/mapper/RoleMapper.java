package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.entity.Role;
import com.hiep.mart.domain.request.RoleRequest;
import com.hiep.mart.domain.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);
}

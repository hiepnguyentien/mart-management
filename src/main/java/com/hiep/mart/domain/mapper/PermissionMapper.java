package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.entity.Permission;
import com.hiep.mart.domain.request.PermissionRequest;
import com.hiep.mart.domain.response.PermissionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
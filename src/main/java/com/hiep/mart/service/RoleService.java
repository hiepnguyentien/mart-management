package com.hiep.mart.service;

import com.hiep.mart.domain.request.RoleRequest;
import com.hiep.mart.domain.response.RoleResponse;

import java.util.List;
import java.util.Locale;

public interface RoleService {
    RoleResponse createRole(RoleRequest request);
    List<RoleResponse> getAllRoles();
    void deleteRole(String role);
    void addRoleToUser(String role, Long userId, Locale locale);
}

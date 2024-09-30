package com.hiep.mart.service.impl;

import com.hiep.mart.domain.mapper.RoleMapper;
import com.hiep.mart.domain.request.RoleRequest;
import com.hiep.mart.domain.response.RoleResponse;
import com.hiep.mart.repository.PermissionRepository;
import com.hiep.mart.repository.RoleRepository;
import com.hiep.mart.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

//    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    @PreAuthorize("hasRole('ADMIN')")
    public RoleResponse createRole(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermission());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

//    @PreAuthorize("hasAuthority('FIND_ALL_ROLE')")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll()
                .stream().map(roleMapper::toRoleResponse)
                .toList();
    }

//    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRole(String role) {
        roleRepository.deleteById(role);
    }

    @Override
    public void addRoleToUser(String role, String userId) {

    }
}
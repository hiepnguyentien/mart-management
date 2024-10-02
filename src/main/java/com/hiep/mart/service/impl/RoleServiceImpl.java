package com.hiep.mart.service.impl;

import com.hiep.mart.domain.entity.Customers;
import com.hiep.mart.domain.entity.Role;
import com.hiep.mart.domain.entity.Users;
import com.hiep.mart.domain.mapper.RoleMapper;
import com.hiep.mart.domain.request.RoleRequest;
import com.hiep.mart.domain.response.RoleResponse;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.PermissionRepository;
import com.hiep.mart.repository.RoleRepository;
import com.hiep.mart.repository.UserRepository;
import com.hiep.mart.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;
    UserRepository userRepository;
    MessageSource messageSource;

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
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void addRoleToUser(String roleName, Long userId, Locale locale) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND, messageSource, locale));

        Role role = roleRepository.findById(roleName)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND, messageSource, locale));

        user.getRoles().add(role);
        userRepository.save(user);
    }
}
package com.hiep.mart.service;

import com.hiep.mart.domain.request.PermissionRequest;
import com.hiep.mart.domain.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    PermissionResponse create(PermissionRequest request);
    List<PermissionResponse> findAll();
    void delete(String permissionName);
}

package com.nkiem.demoIdentity_service.service;

import com.nkiem.demoIdentity_service.dto.request.PermissionRequest;
import com.nkiem.demoIdentity_service.dto.response.PermissionResponse;
import com.nkiem.demoIdentity_service.entity.Permission;
import com.nkiem.demoIdentity_service.mapper.PermissionMapper;
import com.nkiem.demoIdentity_service.responsitory.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse createPermission(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll(){
        return permissionRepository.findAll().stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void deletePermission(String permissionName){
        permissionRepository.deleteById(permissionName);
    }
}

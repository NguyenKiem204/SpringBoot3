package com.nkiem.demoIdentity_service.service;

import com.nkiem.demoIdentity_service.dto.request.RoleRequest;
import com.nkiem.demoIdentity_service.dto.response.PermissionResponse;
import com.nkiem.demoIdentity_service.dto.response.RoleResponse;
import com.nkiem.demoIdentity_service.entity.Role;
import com.nkiem.demoIdentity_service.mapper.RoleMapper;
import com.nkiem.demoIdentity_service.responsitory.PermissionRepository;
import com.nkiem.demoIdentity_service.responsitory.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    PermissionRepository permissionRepository;
    RoleRepository roleRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String roleName){
        roleRepository.deleteById(roleName);
    }
}

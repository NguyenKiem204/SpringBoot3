package com.nkiem.demoIdentity_service.mapper;

import com.nkiem.demoIdentity_service.dto.request.PermissionRequest;
import com.nkiem.demoIdentity_service.dto.response.PermissionResponse;
import com.nkiem.demoIdentity_service.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}

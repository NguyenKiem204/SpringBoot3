package com.nkiem.demoIdentity_service.controller;

import com.nkiem.demoIdentity_service.dto.request.*;
import com.nkiem.demoIdentity_service.dto.response.PermissionResponse;
import com.nkiem.demoIdentity_service.dto.response.RoleResponse;
import com.nkiem.demoIdentity_service.dto.response.UserResponse;
import com.nkiem.demoIdentity_service.entity.User;
import com.nkiem.demoIdentity_service.service.PermissionService;
import com.nkiem.demoIdentity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;
    @PostMapping
    public ApiResponse<PermissionResponse> createRole(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.createPermission(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getRole() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("/{permissionName}")
    public ApiResponse<Void> deletePermission(@PathVariable String permissionName) {
        permissionService.deletePermission(permissionName);
        return ApiResponse.<Void>builder()
                .build();
    }
}

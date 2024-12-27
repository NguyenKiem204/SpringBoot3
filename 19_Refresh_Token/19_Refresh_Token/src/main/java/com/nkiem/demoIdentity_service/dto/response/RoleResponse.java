package com.nkiem.demoIdentity_service.dto.response;

import com.nkiem.demoIdentity_service.entity.Permission;
import com.nkiem.demoIdentity_service.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {
   String name;
   String description;
   Set<PermissionResponse> permissions;
}

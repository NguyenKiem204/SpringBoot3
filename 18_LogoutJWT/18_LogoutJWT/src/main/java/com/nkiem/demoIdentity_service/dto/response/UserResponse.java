package com.nkiem.demoIdentity_service.dto.response;

import com.nkiem.demoIdentity_service.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String userName;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<RoleResponse> roles;
}

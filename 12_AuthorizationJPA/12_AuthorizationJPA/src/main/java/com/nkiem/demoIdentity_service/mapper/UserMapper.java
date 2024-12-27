package com.nkiem.demoIdentity_service.mapper;

import com.nkiem.demoIdentity_service.dto.response.UserResponse;
import com.nkiem.demoIdentity_service.entity.User;
import com.nkiem.demoIdentity_service.dto.request.UserCreationRequest;
import com.nkiem.demoIdentity_service.dto.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

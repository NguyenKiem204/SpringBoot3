package com.kiem.demoApiNomarlize.mapper;

import com.kiem.demoApiNomarlize.dto.request.UserCreationRequest;
import com.kiem.demoApiNomarlize.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
}

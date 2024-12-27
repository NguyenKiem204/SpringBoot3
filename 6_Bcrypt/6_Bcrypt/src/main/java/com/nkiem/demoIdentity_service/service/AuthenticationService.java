package com.nkiem.demoIdentity_service.service;

import com.nkiem.demoIdentity_service.dto.request.AuthenticationRequest;
import com.nkiem.demoIdentity_service.exception.AppException;
import com.nkiem.demoIdentity_service.exception.ErrorCode;
import com.nkiem.demoIdentity_service.responsitory.UserRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;
    public boolean authenticate(AuthenticationRequest request){
        var user =  userRepository.findByUserName(request.getUserName()).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}

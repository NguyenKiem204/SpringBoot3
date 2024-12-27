package com.nkiem.demoIdentity_service.controller;

import com.nkiem.demoIdentity_service.dto.request.ApiResponse;
import com.nkiem.demoIdentity_service.dto.request.AuthenticationRequest;
import com.nkiem.demoIdentity_service.dto.response.AuthenticationResponse;
import com.nkiem.demoIdentity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().code(1000)
                .result(AuthenticationResponse.builder()
                        .authenticated(result).build()).build();
    }
}

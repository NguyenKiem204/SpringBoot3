package com.nkiem.demoIdentity_service.controller;

import com.nimbusds.jose.JOSEException;
import com.nkiem.demoIdentity_service.dto.request.ApiResponse;
import com.nkiem.demoIdentity_service.dto.request.AuthenticationRequest;
import com.nkiem.demoIdentity_service.dto.request.IntrospectRequest;
import com.nkiem.demoIdentity_service.dto.response.AuthenticationResponse;
import com.nkiem.demoIdentity_service.dto.response.IntrospectResponse;
import com.nkiem.demoIdentity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().code(1000)
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().code(1000)
                .result(result)
                .build();
    }
}

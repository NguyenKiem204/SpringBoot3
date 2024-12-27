package com.kiem.demoApiNomarlize.controller;

import com.kiem.demoApiNomarlize.dto.request.AuthenticationRequest;
import com.kiem.demoApiNomarlize.dto.request.IntrospectRequest;
import com.kiem.demoApiNomarlize.dto.response.ApiResponse;
import com.kiem.demoApiNomarlize.dto.response.AuthenticationResponse;
import com.kiem.demoApiNomarlize.dto.response.IntrospectResponse;
import com.kiem.demoApiNomarlize.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.boot.model.internal.XMLContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
       var result =  authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result).build();
    }
    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}

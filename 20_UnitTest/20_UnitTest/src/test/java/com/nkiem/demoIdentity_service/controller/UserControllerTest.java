package com.nkiem.demoIdentity_service.controller;

import com.nkiem.demoIdentity_service.dto.request.UserCreationRequest;
import com.nkiem.demoIdentity_service.dto.response.UserResponse;
import com.nkiem.demoIdentity_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private UserService userService;
    private UserCreationRequest request;
    private UserResponse userResponse;
    private LocalDate dob;
@BeforeEach
void initData(){
    dob = LocalDate.of(2000, 1, 18);
    request = UserCreationRequest.builder()
            .userName("john")
            .firstName("nguyen")
            .lastName("John")
            .password("12345678")
            .dob(dob)
            .build();
    userResponse = UserResponse.builder()
            .id("4dfb-b180-d732fd56375d")
            .userName("john")
            .firstName("nguyen")
            .lastName("John")
            .dob(dob)
            .build();
}

    @Test
    void createUser() {
        log.info("Hello test");
    }
}

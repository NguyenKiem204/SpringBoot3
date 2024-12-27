package com.nkiem.demoIdentity_service.controller;

import com.nkiem.demoIdentity_service.dto.response.UserResponse;
import com.nkiem.demoIdentity_service.entity.User;
import com.nkiem.demoIdentity_service.dto.request.ApiResponse;
import com.nkiem.demoIdentity_service.dto.request.UserCreationRequest;
import com.nkiem.demoIdentity_service.dto.request.UserUpdateRequest;
import com.nkiem.demoIdentity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
         ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
         apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<UserResponse> getUsers() {
       var authentication = SecurityContextHolder.getContext().getAuthentication();
       log.info("Username: {}",authentication.getName());
       authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> UpdateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder().result(userService.updateUser(userId, request)).build();
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User have been deleted";
    }

    @GetMapping("/getmyinfor")
    public ApiResponse<UserResponse> getByMyInfor(){
        return ApiResponse.<UserResponse>builder().result(userService.getMyInfor()).build();
    }

}

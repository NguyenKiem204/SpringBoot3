package com.nkiem.demoIdentity_service.controller;

import com.nkiem.demoIdentity_service.entity.User;
import com.nkiem.demoIdentity_service.request.ApiResponse;
import com.nkiem.demoIdentity_service.request.UserCreationRequest;
import com.nkiem.demoIdentity_service.request.UserUpdateRequest;
import com.nkiem.demoIdentity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
         ApiResponse<User> apiResponse = new ApiResponse<>();
         apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User UpdateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User have been deleted";
    }

}

package com.kiem.demoApiNomarlize.controller;

import com.kiem.demoApiNomarlize.model.User;
import com.kiem.demoApiNomarlize.dto.response.ApiResponse;
import com.kiem.demoApiNomarlize.dto.request.UserCreationRequest;
import com.kiem.demoApiNomarlize.service.UserService;
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
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    public List<User> getListUser() {
        return userService.getListUser();
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String id) {
        return userService.getUser(id);
    }
    @DeleteMapping("/{userName}")
    public String deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return "User have been deleted";
    }
}

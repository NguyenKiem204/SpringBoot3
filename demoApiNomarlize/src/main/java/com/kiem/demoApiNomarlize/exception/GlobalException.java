package com.kiem.demoApiNomarlize.exception;

import com.kiem.demoApiNomarlize.model.User;
import com.kiem.demoApiNomarlize.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    ResponseEntity<ApiResponse<User>> handleRuntimeException(RuntimeException exception){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(9999);
        apiResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler
    ResponseEntity<ApiResponse<User>> handleAppException(AppException exception){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(exception.getErrorCode().getCode());
        apiResponse.setMessage(exception.getErrorCode().getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler
    ResponseEntity<ApiResponse<User>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(9998);
        apiResponse.setMessage(exception.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}

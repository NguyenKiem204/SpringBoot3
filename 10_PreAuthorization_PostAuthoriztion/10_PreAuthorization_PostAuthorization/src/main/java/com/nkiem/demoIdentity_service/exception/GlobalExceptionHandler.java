package com.nkiem.demoIdentity_service.exception;

import com.nkiem.demoIdentity_service.entity.User;
import com.nkiem.demoIdentity_service.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;


@ControllerAdvice
public class GlobalExceptionHandler {
    //Nhung ngoai le khac khong xac dinh
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingUncategorizedException(Exception exception) {
        ApiResponse<User> apiResponse = new ApiResponse<User>();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    // AppException để giải quyết việc API response không bị cố định ở "code"
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse<User> apiResponse = new ApiResponse<User>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatus()).body(apiResponse);
    }

    @ExceptionHandler(value = AuthorizationDeniedException.class)
    ResponseEntity<ApiResponse<User>> handlingAuthorizationDeniedException(AuthorizationDeniedException exception){
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;
        ApiResponse<User> apiResponse = ApiResponse.<User>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(apiResponse);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse<User>> handlingValidation(MethodArgumentNotValidException exception) {
        String enKey = exception.getFieldError().getDefaultMessage(); // để lấy ra cái key message @Size(min = 8, message = "PASSWORD_INVALID")
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enKey);
        } catch (IllegalArgumentException e) {

        }
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = ParseException.class)
    ResponseEntity<ApiResponse<Object>> handleParseException(ParseException exception) {
        ErrorCode errorCode = ErrorCode.UNKNOW_TOKEN;
        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}

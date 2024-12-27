package com.nkiem.demoIdentity_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXEPTION(99999, "Ngoai le khong xac dinh", HttpStatus.INTERNAL_SERVER_ERROR),
//  phòng trường hợp cái enkey message bị lỗi
    INVALID_KEY(1001, "Invalid message key", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "UserName must be at least 3 character", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password must be at least 8 character", HttpStatus.BAD_REQUEST),
    USERID_NOTEXISTED(1005, "User ID not existed", HttpStatus.NOT_FOUND),
    USER_NOT_EXISTED(1006, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1007, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1008, "You do not have permission", HttpStatus.FORBIDDEN),
    UNKNOW_TOKEN(1009, "Token error", HttpStatus.UNAUTHORIZED),
    INVALID_DOB(1010, "Invalid date of birth", HttpStatus.BAD_REQUEST);

    ;
    private int code;
    private String message;
    private HttpStatusCode status;


}

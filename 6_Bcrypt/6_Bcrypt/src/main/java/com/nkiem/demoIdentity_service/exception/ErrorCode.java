package com.nkiem.demoIdentity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXEPTION(99999, "Ngoai le khong xac dinh"),
//  phòng trường hợp cái enkey message bị lỗi
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "UserName must be at least 3 character"),
    PASSWORD_INVALID(1004, "Password must be at least 8 character"),
    USERID_NOTEXISTED(1005, "User ID not existed"),
    USER_NOT_EXISTED(1006, "User not existed")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

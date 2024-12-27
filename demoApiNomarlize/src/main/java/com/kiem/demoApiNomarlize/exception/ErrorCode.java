package com.kiem.demoApiNomarlize.exception;

import lombok.Data;

public enum ErrorCode {
    USER_EXISTED(1000, "UserName existed"),
    USER_NOTEXISTED(1001, "User not existed"),
    UNAUTHENTICATED(1005, "Uauthenticated")
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

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

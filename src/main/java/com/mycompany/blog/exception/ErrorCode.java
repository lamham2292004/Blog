package com.mycompany.blog.exception;

public enum ErrorCode {
    INVALID_KEY(1000,"Sai key rồi kìa"),
    EMAIL_EXITED(1001,"Email đã tồn tại"),
    PASS_INVALID(1002,"Password chưa đủ 8 kí tự"),
    FIRSTNAME_INVALID(1003,"Tên phải đủ 3 ký tự"),
    LASTNAME_INVALID(1004,"Tên phải đủ 3 ký tự"),
    EMAIL_NOT_EXITED(1005,"Email không tồn tại"),
    ADDRESS_INVALID(1006,"Địa chỉ phải có ít nhất 2 ký tự"),
    UNAUTHENTICATED(1007,"unthenticasted"),
    USER_EXISTS(1008,"user đã tồn tại"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

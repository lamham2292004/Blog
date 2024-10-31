package com.mycompany.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001,"Sai key rồi kìa", HttpStatus.BAD_REQUEST),
    EMAIL_EXITED(1002,"Email đã tồn tại", HttpStatus.BAD_REQUEST),
    PASS_INVALID(1003,"Password chưa đủ 8 kí tự",HttpStatus.BAD_REQUEST),
    FIRSTNAME_INVALID(1004,"Tên phải đủ 3 ký tự",HttpStatus.BAD_REQUEST),
    LASTNAME_INVALID(1005,"Tên phải đủ 3 ký tự",HttpStatus.BAD_REQUEST),
    EMAIL_NOT_EXITED(1006,"Email không tồn tại",HttpStatus.NOT_FOUND),
    ADDRESS_INVALID(1007,"Địa chỉ phải có ít nhất 2 ký tự",HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1008,"unthenticasted",HttpStatus.UNAUTHORIZED),
    USER_EXISTS(1009,"user đã tồn tại",HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(1010, "you do not have permisstion",HttpStatus.FORBIDDEN),
    ;

    ErrorCode(int code, String message,HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;


}

package com.hiep.mart.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized.exception", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(9001, "invalid.key", HttpStatus.BAD_REQUEST),

    PRODUCT_NOT_FOUND(1001, "product.not.found", HttpStatus.BAD_REQUEST),

    CATEGORY_NOT_FOUND(2001, "category.not.found", HttpStatus.BAD_REQUEST),

    SUPPLIER_NOT_FOUND(3001, "supplier.not.found", HttpStatus.BAD_REQUEST),

    UNAUTHORIZED(9001, "unauthorized", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(9002, "unauthenticated", HttpStatus.UNAUTHORIZED),;
    private final int code;
    private final String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
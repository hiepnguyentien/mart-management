package com.hiep.mart.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(99999, "uncategorized.exception", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(90000, "invalid.key", HttpStatus.BAD_REQUEST),

    QUANTITY_MUST_GREATER_THAN_ZERO(1, "quantity.must.greater.than.zero", HttpStatus.BAD_REQUEST),
    PRICE_MUST_GREATER_THAN_ZERO(2, "price.must.greater.than.zero", HttpStatus.BAD_REQUEST),
    REQUIRED_FIELD_MISSING(3, "required.field.missing", HttpStatus.BAD_REQUEST),
    STATUS_ALREADY_ACTIVE(4, "status.already_active", HttpStatus.BAD_REQUEST),
    STATUS_ALREADY_INACTIVE(5, "status.already_inactive", HttpStatus.BAD_REQUEST),

    PRODUCT_NOT_FOUND(1001, "product.not.found", HttpStatus.BAD_REQUEST),

    CATEGORY_NOT_FOUND(2001, "category.not.found", HttpStatus.BAD_REQUEST),

    SUPPLIER_NOT_FOUND(3001, "supplier.not.found", HttpStatus.BAD_REQUEST),

    CART_NOT_FOUND(4001, "cart.not.found", HttpStatus.BAD_REQUEST),

    EMPLOYEE_NOT_FOUND(5001, "employee.not.found", HttpStatus.BAD_REQUEST),

    FINANCE_NOT_FOUND(6001, "finance.not.found", HttpStatus.BAD_REQUEST),

    ORDER_NOT_FOUND(7001, "order.not.found", HttpStatus.BAD_REQUEST),

    PROMOTION_NOT_FOUND(8001, "promotion.not.found", HttpStatus.BAD_REQUEST),

    SHIFT_NOT_FOUND(9001, "shift.not.found", HttpStatus.BAD_REQUEST),

    UNAUTHORIZED(90001, "unauthorized", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(90002, "unauthenticated", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND(90003, "user.not.found", HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(90004, "role.not.found", HttpStatus.BAD_REQUEST),;
    private final int code;
    private final String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
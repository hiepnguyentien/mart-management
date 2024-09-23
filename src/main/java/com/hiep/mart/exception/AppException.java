package com.hiep.mart.exception;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class AppException extends RuntimeException {
    private final ErrorCode errorCode;
    private final MessageSource messageSource;
    private final Locale locale;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public AppException(ErrorCode errorCode, MessageSource messageSource, Locale locale) {
        super(messageSource.getMessage(errorCode.getMessage(), null, locale));
        this.errorCode = errorCode;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public String getLocalizedMessage() {
        return messageSource.getMessage(errorCode.getMessage(), null, locale);
    }
}


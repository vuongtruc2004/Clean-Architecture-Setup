package org.yourapp.user.exception;

import org.yourapp.shared.exception.ErrorCode;

public enum UserApplicationErrorCode implements ErrorCode {
    USER_NOT_FOUND("USER_404", "user.not.found");

    private final String code;
    private final String title;

    UserApplicationErrorCode(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

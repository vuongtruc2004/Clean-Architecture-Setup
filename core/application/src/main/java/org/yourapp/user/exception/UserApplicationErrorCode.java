package org.yourapp.user.exception;

import org.yourapp.shared.exception.ErrorCode;

public enum UserApplicationErrorCode implements ErrorCode {
    USER_NOT_FOUND("USER_404", "user.not.found");

    private final String code;
    private final String detailMessageKey;

    UserApplicationErrorCode(String code, String detailMessageKey) {
        this.code = code;
        this.detailMessageKey = detailMessageKey;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDetailMessageKey() {
        return detailMessageKey;
    }
}

package org.yourapp.order.exception;

import org.yourapp.shared.exception.ErrorCode;

public enum OrderApplicationErrorCode implements ErrorCode {
    ;

    private final String code;
    private final String title;

    OrderApplicationErrorCode(String code, String title) {
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

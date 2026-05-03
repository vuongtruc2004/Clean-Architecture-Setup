package org.yourapp.order.exception;

import org.yourapp.shared.exception.ErrorCode;

public enum OrderApplicationErrorCode implements ErrorCode {
    ;

    private final String code;
    private final String detailMessageKey;

    OrderApplicationErrorCode(String code, String detailMessageKey) {
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

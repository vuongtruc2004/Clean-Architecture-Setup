package org.yourapp.shared.exception;

public enum SharedErrorCode implements ErrorCode {
    INVALID_MONEY_VALUE("SHARED_001", "shared.money.invalid");

    private final String code;
    private final String detailMessageKey;

    SharedErrorCode(String code, String detailMessageKey) {
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

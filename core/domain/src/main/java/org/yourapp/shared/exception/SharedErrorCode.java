package org.yourapp.shared.exception;

public enum SharedErrorCode implements ErrorCode {
    INVALID_MONEY_VALUE("SHARED_001", "shared.money.invalid");

    private final String code;
    private final String title;

    SharedErrorCode(String code, String title) {
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

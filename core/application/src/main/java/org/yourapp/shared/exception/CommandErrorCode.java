package org.yourapp.shared.exception;

public enum CommandErrorCode implements ErrorCode {
    REQUIRED_FIELD_MISSING("COMMAND_001", "required.field.missing"),
    EMPTY_LIST("COMMAND_002", "empty.list"),
    ;

    private final String code;
    private final String detailMessageKey;

    CommandErrorCode(String code, String detailMessageKey) {
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

package org.yourapp.shared.exception;

public enum CommandErrorCode implements ErrorCode {
    REQUIRED_FIELD_MISSING("COMMAND_001", "required.field.missing"),
    EMPTY_LIST("COMMAND_002", "empty.list"),
    ;

    private final String code;
    private final String title;

    CommandErrorCode(String code, String title) {
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

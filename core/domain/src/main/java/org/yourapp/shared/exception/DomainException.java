package org.yourapp.shared.exception;

public class DomainException extends RuntimeException {
    private final ErrorCode errorCode;

    public DomainException(ErrorCode errorCode) {
        super(errorCode.getDetailMessageKey());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

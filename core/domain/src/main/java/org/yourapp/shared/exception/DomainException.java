package org.yourapp.shared.exception;

public class DomainException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String detailMessage;

    public DomainException(ErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}

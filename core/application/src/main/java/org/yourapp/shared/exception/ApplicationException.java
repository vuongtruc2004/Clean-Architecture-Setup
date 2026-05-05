package org.yourapp.shared.exception;

public class ApplicationException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String detailMessage;

    public ApplicationException(ErrorCode errorCode, String detailMessage) {
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

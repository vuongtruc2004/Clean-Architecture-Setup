package org.yourapp.shared.exception;

public class InvalidCommandException extends ApplicationException {
    public InvalidCommandException(ErrorCode errorCode) {
        super(errorCode);
    }
}

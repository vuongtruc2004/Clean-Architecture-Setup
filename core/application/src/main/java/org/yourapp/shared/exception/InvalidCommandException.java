package org.yourapp.shared.exception;

public class InvalidCommandException extends ApplicationException {

    public InvalidCommandException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}

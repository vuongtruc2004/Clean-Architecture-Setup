package org.yourapp.shared.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}

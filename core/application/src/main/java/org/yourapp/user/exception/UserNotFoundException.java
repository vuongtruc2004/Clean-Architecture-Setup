package org.yourapp.user.exception;

import org.yourapp.shared.exception.ApplicationException;
import org.yourapp.shared.exception.ErrorCode;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}

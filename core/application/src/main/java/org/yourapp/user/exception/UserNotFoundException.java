package org.yourapp.user.exception;

import org.yourapp.shared.exception.ApplicationException;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(Long id) {
        super(UserApplicationErrorCode.USER_NOT_FOUND);
    }
}

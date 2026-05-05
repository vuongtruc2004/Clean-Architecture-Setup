package org.yourapp.user.model;

import org.yourapp.shared.exception.DomainException;
import org.yourapp.user.exception.UserErrorCode;

public record Age(short value) {

    private static final short MIN = 18;
    private static final short MAX = 65;

    public Age {
        if (value < MIN || value > MAX) {
            throw new DomainException(
                    UserErrorCode.AGE_NOT_VALID,
                    value + " is not a valid age. Age must be between " + MIN + " and " + MAX
            );
        }
    }
}

package org.yourapp.user.model;

import org.yourapp.shared.exception.DomainException;
import org.yourapp.user.exception.UserErrorCode;

public record Age(short value) {
    public Age {
        if (value < 18 || value > 65) {
            throw new DomainException(UserErrorCode.AGE_NOT_VALID);
        }
    }
}

package org.yourapp.user.model;

import org.yourapp.shared.exception.DomainException;
import org.yourapp.user.exception.UserErrorCode;

import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Email {
        if (value == null || value.isBlank()) {
            throw new DomainException(UserErrorCode.EMAIL_REQUIRED);
        }

        value = value.trim().toLowerCase();

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainException(UserErrorCode.EMAIL_NOT_VALID);
        }
    }
}

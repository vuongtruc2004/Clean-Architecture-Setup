package org.yourapp.shared.model;

import org.yourapp.order.model.Quantity;
import org.yourapp.shared.exception.DomainException;
import org.yourapp.shared.exception.SharedErrorCode;

import java.math.BigDecimal;

public final class Money {
    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

    public static Money of(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException(SharedErrorCode.INVALID_MONEY_VALUE);
        }
        return new Money(value);
    }

    public Money multiply(Quantity quantity) {
        return new Money(value.multiply(BigDecimal.valueOf(quantity.getValue())));
    }

    public Money add(Money other) {
        return new Money(value.add(other.value));
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public BigDecimal getValue() {
        return value;
    }
}

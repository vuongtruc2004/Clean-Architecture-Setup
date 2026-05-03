package org.yourapp.order.model;

import org.yourapp.order.exception.OrderErrorCode;
import org.yourapp.shared.exception.DomainException;

public final class Quantity {
    private final int value;

    private Quantity(int value) {
        this.value = value;
    }

    public static Quantity of(int value) {
        if (value <= 0) {
            throw new DomainException(OrderErrorCode.INVALID_QUANTITY);
        }
        return new Quantity(value);
    }

    public int getValue() {
        return value;
    }
}
package org.yourapp.order.exception;

import org.yourapp.shared.exception.ErrorCode;

public enum OrderErrorCode implements ErrorCode {
    ORDER_ITEMS_EMPTY("ORDER_001", "order.items.empty"),
    ORDER_ALREADY_PAID("ORDER_002", "order.already_paid"),
    ORDER_CANCELLED("ORDER_003", "order.cancelled"),
    ORDER_ALREADY_DELIVERED("ORDER_004", "order.already_delivered"),
    INVALID_QUANTITY("ORDER_005", "order.quantity.invalid"),
    INVALID_PRICE("ORDER_006", "order.price.invalid"),
    ORDER_NOT_MODIFIABLE("ORDER_007", "order.not.modifiable");

    private final String code;
    private final String title;

    OrderErrorCode(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

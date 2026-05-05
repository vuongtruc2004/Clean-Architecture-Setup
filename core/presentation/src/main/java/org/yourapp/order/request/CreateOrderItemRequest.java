package org.yourapp.order.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateOrderItemRequest(
        @NotNull Long productId,
        @NotNull BigDecimal unitPrice,
        int quantity
) {
}

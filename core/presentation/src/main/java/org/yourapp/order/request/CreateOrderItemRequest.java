package org.yourapp.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateOrderItemRequest(
        @NotNull Long productId,
        @NotNull BigDecimal unitPrice,
        int quantity
) {
}

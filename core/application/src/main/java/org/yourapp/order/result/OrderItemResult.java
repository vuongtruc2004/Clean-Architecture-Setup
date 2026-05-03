package org.yourapp.order.result;

import java.math.BigDecimal;

public record OrderItemResult(
        Long id,
        Long productId,
        int quantity,
        BigDecimal unitPrice
) {
}

package org.yourapp.order.response;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long id,
        Long productId,
        int quantity,
        BigDecimal unitPrice
) {
}

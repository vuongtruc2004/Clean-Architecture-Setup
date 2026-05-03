package org.yourapp.order.result;

import java.util.List;

public record OrderResult(
        Long id,
        Long userId,
        String status,
        List<OrderItemResult> orderItems
) {

}

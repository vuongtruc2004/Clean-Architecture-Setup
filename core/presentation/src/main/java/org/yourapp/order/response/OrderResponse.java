package org.yourapp.order.response;

import java.util.List;

public record OrderResponse(
        Long id,
        Long userId,
        String status,
        List<OrderItemResponse> orderItems
) {
}

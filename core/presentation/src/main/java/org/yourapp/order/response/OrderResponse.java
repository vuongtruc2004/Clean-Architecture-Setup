package org.yourapp.order.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderResponse(
        Long id,
        Long userId,
        String status,
        List<OrderItemResponse> orderItems
) {
}

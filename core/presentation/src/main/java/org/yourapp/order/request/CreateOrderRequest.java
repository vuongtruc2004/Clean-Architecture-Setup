package org.yourapp.order.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateOrderRequest(
        @NotNull Long userId,
        @NotEmpty List<CreateOrderItemRequest> orderItems
) {
}

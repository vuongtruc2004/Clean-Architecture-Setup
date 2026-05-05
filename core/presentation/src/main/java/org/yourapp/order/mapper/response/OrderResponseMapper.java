package org.yourapp.order.mapper.response;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourapp.order.response.OrderItemResponse;
import org.yourapp.order.response.OrderResponse;
import org.yourapp.order.result.OrderResult;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderResponseMapper {
    private final OrderItemResponseMapper orderItemResponseMapper;

    public OrderResponse mapOrderResultToOrderResponse(OrderResult orderResult) {
        List<OrderItemResponse> orderItemResponses = orderResult
                .orderItems()
                .stream()
                .map(orderItemResponseMapper::mapOrderItemResultToOrderItemResponse)
                .toList();

        return new OrderResponse(
                orderResult.id(),
                orderResult.userId(),
                orderResult.status(),
                orderItemResponses
        );
    }
}

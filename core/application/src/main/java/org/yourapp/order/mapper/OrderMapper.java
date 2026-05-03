package org.yourapp.order.mapper;

import org.yourapp.order.model.Order;
import org.yourapp.order.result.OrderResult;

public class OrderMapper {
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    public OrderResult mapOrderToOrderResult(Order order) {
        return new OrderResult(
                order.getId(),
                order.getUserId(),
                order.getStatus().name(),
                order.getOrderItems()
                        .stream()
                        .map(orderItemMapper::mapOrderItemToOrderItemResult)
                        .toList()
        );
    }
}

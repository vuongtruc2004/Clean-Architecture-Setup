package org.yourapp.order.mapper.result;

import org.yourapp.order.model.Order;
import org.yourapp.order.result.OrderResult;

public class OrderResultMapper {
    private final OrderItemResultMapper orderItemResultMapper;

    public OrderResultMapper(OrderItemResultMapper orderItemResultMapper) {
        this.orderItemResultMapper = orderItemResultMapper;
    }

    public OrderResult mapOrderToOrderResult(Order order) {
        return new OrderResult(
                order.getId(),
                order.getUserId(),
                order.getStatus().name(),
                order.getOrderItems()
                        .stream()
                        .map(orderItemResultMapper::mapOrderItemToOrderItemResult)
                        .toList()
        );
    }
}

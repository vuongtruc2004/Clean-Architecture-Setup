package org.yourapp.order.mapper.result;

import org.yourapp.order.model.OrderItem;
import org.yourapp.order.result.OrderItemResult;

public class OrderItemResultMapper {
    public OrderItemResult mapOrderItemToOrderItemResult(OrderItem orderItem) {
        return new OrderItemResult(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getQuantity().getValue(),
                orderItem.getUnitPrice().getValue()
        );
    }
}

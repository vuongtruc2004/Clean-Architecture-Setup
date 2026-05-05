package org.yourapp.order.mapper.response;

import org.springframework.stereotype.Component;
import org.yourapp.order.response.OrderItemResponse;
import org.yourapp.order.result.OrderItemResult;

@Component
public class OrderItemResponseMapper {
    public OrderItemResponse mapOrderItemResultToOrderItemResponse(OrderItemResult orderItemResult) {
        return new OrderItemResponse(
                orderItemResult.id(),
                orderItemResult.productId(),
                orderItemResult.quantity(),
                orderItemResult.unitPrice()
        );
    }
}

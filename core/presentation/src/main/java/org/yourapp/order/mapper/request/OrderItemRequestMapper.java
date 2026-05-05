package org.yourapp.order.mapper.request;

import org.springframework.stereotype.Component;
import org.yourapp.order.command.CreateOrderItemCommand;
import org.yourapp.order.request.CreateOrderItemRequest;

@Component
public class OrderItemRequestMapper {
    public CreateOrderItemCommand mapCreateOrderItemRequestToCreateOrderItemCommand(CreateOrderItemRequest request) {
        return new CreateOrderItemCommand(
                request.productId(),
                request.unitPrice(),
                request.quantity()
        );
    }
}

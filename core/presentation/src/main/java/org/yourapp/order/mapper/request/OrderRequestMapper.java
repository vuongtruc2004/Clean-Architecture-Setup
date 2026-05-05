package org.yourapp.order.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourapp.order.command.CreateOrderCommand;
import org.yourapp.order.command.CreateOrderItemCommand;
import org.yourapp.order.request.CreateOrderRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderRequestMapper {
    private final OrderItemRequestMapper orderItemRequestMapper;

    public CreateOrderCommand mapCreateOrderRequestToCreateOrderCommand(CreateOrderRequest request) {
        List<CreateOrderItemCommand> createOrderItemCommands = request
                .orderItems()
                .stream()
                .map(orderItemRequestMapper::mapCreateOrderItemRequestToCreateOrderItemCommand)
                .toList();

        return new CreateOrderCommand(
                request.userId(),
                createOrderItemCommands
        );
    }
}

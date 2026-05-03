package org.yourapp.order.mapper;

import org.yourapp.order.command.CreateOrderItemCommand;
import org.yourapp.order.model.OrderItem;
import org.yourapp.order.model.Quantity;
import org.yourapp.order.result.OrderItemResult;
import org.yourapp.shared.model.Money;

public class OrderItemMapper {
    public OrderItemResult mapOrderItemToOrderItemResult(OrderItem orderItem) {
        return new OrderItemResult(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getQuantity().getValue(),
                orderItem.getUnitPrice().getValue()
        );
    }

    public OrderItem mapCreateOrderItemCommandToOrderItem(CreateOrderItemCommand command) {
        return OrderItem.create(
                command.productId(),
                Quantity.of(command.quantity()),
                Money.of(command.unitPrice())
        );
    }
}

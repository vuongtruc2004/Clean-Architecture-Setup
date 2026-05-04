package org.yourapp.order.mapper.command;

import org.yourapp.order.command.CreateOrderItemCommand;
import org.yourapp.order.model.OrderItem;
import org.yourapp.order.model.Quantity;
import org.yourapp.shared.model.Money;

public class OrderItemCommandMapper {
    public OrderItem mapCreateOrderItemCommandToOrderItem(CreateOrderItemCommand command) {
        return OrderItem.create(
                command.productId(),
                Quantity.of(command.quantity()),
                Money.of(command.unitPrice())
        );
    }
}

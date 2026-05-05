package org.yourapp.order.command;

import org.yourapp.shared.exception.CommandErrorCode;
import org.yourapp.shared.exception.InvalidCommandException;

import java.util.List;

public record CreateOrderCommand(
        Long userId,
        List<CreateOrderItemCommand> orderItems
) {
    public CreateOrderCommand {
        if (userId == null) {
            throw new InvalidCommandException(
                    CommandErrorCode.REQUIRED_FIELD_MISSING,
                    "userId is required"
            );
        }

        if (orderItems == null || orderItems.isEmpty()) {
            throw new InvalidCommandException(
                    CommandErrorCode.EMPTY_LIST,
                    "orderItems is required"
            );
        }
    }
}

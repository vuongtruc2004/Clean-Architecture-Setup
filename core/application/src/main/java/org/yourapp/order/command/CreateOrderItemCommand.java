package org.yourapp.order.command;

import org.yourapp.shared.exception.CommandErrorCode;
import org.yourapp.shared.exception.InvalidCommandException;

import java.math.BigDecimal;

public record CreateOrderItemCommand(
        Long productId,
        BigDecimal unitPrice,
        int quantity
) {
    public CreateOrderItemCommand {
        if (productId == null) {
            throw new InvalidCommandException(CommandErrorCode.REQUIRED_FIELD_MISSING);
        }
        if (unitPrice == null) {
            throw new InvalidCommandException(CommandErrorCode.REQUIRED_FIELD_MISSING);
        }
    }
}

package org.yourapp.order.port.in;

import org.yourapp.order.command.CreateOrderCommand;
import org.yourapp.order.result.OrderResult;

public interface CreateOrderInputPort {
    OrderResult createOrder(CreateOrderCommand command);
}

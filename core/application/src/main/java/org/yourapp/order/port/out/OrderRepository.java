package org.yourapp.order.port.out;

import org.yourapp.order.model.Order;

import java.util.Optional;

public interface OrderRepository {
    Order create(Order order);

    Optional<Order> findById(Long id);
}

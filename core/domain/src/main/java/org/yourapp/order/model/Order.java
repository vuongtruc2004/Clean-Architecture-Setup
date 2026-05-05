package org.yourapp.order.model;

import org.yourapp.order.exception.OrderErrorCode;
import org.yourapp.shared.exception.DomainException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private OrderStatus status;
    private final List<OrderItem> orderItems = new ArrayList<>();

    private Order(Long id, Long userId, OrderStatus status, List<OrderItem> orderItems) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.orderItems.addAll(orderItems);
    }

    // create new order
    public static Order create(Long userId, List<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty()) {
            throw new DomainException(
                    OrderErrorCode.ORDER_ITEMS_EMPTY,
                    "Order items cannot be empty"
            );
        }
        return new Order(null, userId, OrderStatus.DRAFT, orderItems);
    }

    // reconstitute order from DB
    public static Order reconstitute(Long id, Long userId, OrderStatus status, List<OrderItem> orderItems) {
        return new Order(id, userId, status, orderItems);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}

package org.yourapp.order.model;

import org.yourapp.order.exception.OrderErrorCode;
import org.yourapp.shared.exception.DomainException;
import org.yourapp.shared.model.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private OrderStatus status;
    private final List<OrderItem> orderItems = new ArrayList<>();

    private Order(Long userId, List<OrderItem> orderItems) {
        this.userId = userId;
        this.orderItems.addAll(orderItems);
        this.status = OrderStatus.DRAFT;
    }

    public static Order create(Long userId, List<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty()) {
            throw new DomainException(OrderErrorCode.ORDER_ITEMS_EMPTY);
        }
        return new Order(userId, orderItems);
    }

    public void addOrderItem(OrderItem orderItem) {
        if (status != OrderStatus.DRAFT) {
            throw new DomainException(OrderErrorCode.ORDER_NOT_MODIFIABLE);
        }
        orderItems.add(orderItem);
    }

    public void pay() {
        if (status == OrderStatus.CANCELLED) {
            throw new DomainException(OrderErrorCode.ORDER_CANCELLED);
        }
        if (status == OrderStatus.PAID) {
            throw new DomainException(OrderErrorCode.ORDER_ALREADY_PAID);
        }

        status = OrderStatus.PAID;
    }

    public void cancel() {
        if (status == OrderStatus.CANCELLED) {
            throw new DomainException(OrderErrorCode.ORDER_CANCELLED);
        }

        if (status == OrderStatus.DELIVERED) {
            throw new DomainException(OrderErrorCode.ORDER_ALREADY_DELIVERED);
        }

        if (status == OrderStatus.PAID) {
            throw new DomainException(OrderErrorCode.ORDER_ALREADY_PAID);
        }

        status = OrderStatus.CANCELLED;
    }

    public Money getTotalPrice() {
        return orderItems
                .stream()
                .map(OrderItem::subtotal)
                .reduce(Money.zero(), Money::add);
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

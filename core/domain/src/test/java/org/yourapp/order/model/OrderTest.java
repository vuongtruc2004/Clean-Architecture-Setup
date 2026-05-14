package org.yourapp.order.model;

import org.junit.jupiter.api.Test;
import org.yourapp.order.exception.OrderErrorCode;
import org.yourapp.shared.exception.DomainException;
import org.yourapp.shared.model.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void create_RightOrder_ReturnOrder() {
        // Arrange (Given)
        Long userId = 1L;
        OrderItem item = OrderItem.create(1L, Quantity.of(10), Money.of(BigDecimal.valueOf(15.6)));
        List<OrderItem> orderItems = List.of(item);

        // Act (When)
        Order order = Order.create(userId, orderItems);

        // Assert (Then)
        assertNotNull(order);
        assertEquals(OrderStatus.DRAFT, order.getStatus());
    }

    @Test
    void create_WrongOrder_ThrowDomainException() {
        // Arrange (Given)
        Long userId = 1L;
        List<OrderItem> orderItems = new ArrayList<>();

        // Act (When)
        DomainException exception = assertThrows(
                DomainException.class,
                () -> Order.create(userId, orderItems)
        );

        // Assert (Then)
        assertEquals(OrderErrorCode.ORDER_ITEMS_EMPTY, exception.getErrorCode());
    }
}
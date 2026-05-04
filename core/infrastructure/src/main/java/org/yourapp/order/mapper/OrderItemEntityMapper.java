package org.yourapp.order.mapper;

import org.springframework.stereotype.Component;
import org.yourapp.order.entity.OrderItemEntity;
import org.yourapp.order.model.OrderItem;
import org.yourapp.order.model.Quantity;
import org.yourapp.shared.model.Money;

@Component
public class OrderItemEntityMapper {
    public OrderItem mapOrderItemEntityToOrderItem(OrderItemEntity orderItemEntity) {
        return OrderItem.reconstitute(
                orderItemEntity.getId(),
                orderItemEntity.getProductId(),
                Quantity.of(orderItemEntity.getQuantity()),
                Money.of(orderItemEntity.getUnitPrice())
        );
    }

    public OrderItemEntity mapOrderItemToOrderItemEntity(OrderItem orderItem) {
        return OrderItemEntity.builder()
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity().getValue())
                .unitPrice(orderItem.getUnitPrice().getValue())
                .build();
    }
}

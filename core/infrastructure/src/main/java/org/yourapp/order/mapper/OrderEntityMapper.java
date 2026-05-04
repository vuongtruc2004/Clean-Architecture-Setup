package org.yourapp.order.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourapp.order.entity.OrderEntity;
import org.yourapp.order.entity.OrderItemEntity;
import org.yourapp.order.model.Order;
import org.yourapp.order.model.OrderItem;
import org.yourapp.user.entity.UserEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderEntityMapper {
    private final OrderItemEntityMapper orderItemEntityMapper;

    public Order mapOrderEntityToOrder(OrderEntity orderEntity) {
        List<OrderItem> orderItems = orderEntity.getOrderItems()
                .stream()
                .map(orderItemEntityMapper::mapOrderItemEntityToOrderItem)
                .toList();

        return Order.reconstitute(
                orderEntity.getId(),
                orderEntity.getUser().getId(),
                orderEntity.getStatus(),
                orderItems
        );
    }

    public OrderEntity mapOrderToOrderEntity(Order order, UserEntity userEntity) {
        List<OrderItemEntity> orderItemEntities = order.getOrderItems()
                .stream().map(orderItemEntityMapper::mapOrderItemToOrderItemEntity)
                .toList();

        return OrderEntity.builder()
                .status(order.getStatus())
                .user(userEntity)
                .orderItems(orderItemEntities)
                .build();
    }
}

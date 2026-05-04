package org.yourapp.order.mapper;

import org.mapstruct.Mapper;
import org.yourapp.order.entity.OrderItemEntity;
import org.yourapp.order.model.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemPersistenceMapper {

    OrderItem mapOrderItemEntityToOrderItem(OrderItemEntity orderItemEntity);
}

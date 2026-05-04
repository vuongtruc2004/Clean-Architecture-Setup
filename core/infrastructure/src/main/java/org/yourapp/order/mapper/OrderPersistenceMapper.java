package org.yourapp.order.mapper;

import org.mapstruct.Mapper;
import org.yourapp.order.entity.OrderEntity;
import org.yourapp.order.model.Order;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    Order mapOrderEntityToOrder(OrderEntity orderEntity);
}

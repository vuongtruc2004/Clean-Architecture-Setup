package org.yourapp.order.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.yourapp.order.entity.OrderEntity;
import org.yourapp.order.mapper.OrderEntityMapper;
import org.yourapp.order.model.Order;
import org.yourapp.order.port.out.OrderRepository;
import org.yourapp.order.repository.OrderJpaRepository;
import org.yourapp.user.entity.UserEntity;
import org.yourapp.user.exception.UserNotFoundException;
import org.yourapp.user.repository.UserJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Override
    public Order create(Order order) {
        UserEntity userEntity = userJpaRepository.findById(order.getUserId())
                .orElseThrow(() -> new UserNotFoundException(order.getUserId()));

        OrderEntity orderEntity = orderEntityMapper.mapOrderToOrderEntity(order, userEntity);
        OrderEntity savedOrderEntity = orderJpaRepository.save(orderEntity);
        return orderEntityMapper.mapOrderEntityToOrder(savedOrderEntity);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderJpaRepository.findById(id)
                .map(orderEntityMapper::mapOrderEntityToOrder);
    }
}

package org.yourapp.order.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.yourapp.order.mapper.OrderPersistenceMapper;
import org.yourapp.order.model.Order;
import org.yourapp.order.port.out.OrderRepository;
import org.yourapp.order.repository.OrderJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }
}

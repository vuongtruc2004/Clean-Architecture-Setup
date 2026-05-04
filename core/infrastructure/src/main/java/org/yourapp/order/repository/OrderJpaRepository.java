package org.yourapp.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourapp.order.entity.OrderEntity;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}

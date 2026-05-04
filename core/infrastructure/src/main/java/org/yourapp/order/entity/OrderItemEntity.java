package org.yourapp.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.yourapp.shared.entity.BaseEntity;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemEntity extends BaseEntity {
    Long productId;

    Integer quantity;

    BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderEntity order;
}

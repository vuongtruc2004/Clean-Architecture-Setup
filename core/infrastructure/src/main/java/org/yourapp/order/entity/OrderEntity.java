package org.yourapp.order.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.yourapp.order.model.OrderStatus;
import org.yourapp.shared.entity.BaseEntity;
import org.yourapp.user.entity.UserEntity;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItemEntity> orderItems;
}

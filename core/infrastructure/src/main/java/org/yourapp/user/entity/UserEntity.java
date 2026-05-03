package org.yourapp.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.yourapp.order.entity.OrderEntity;
import org.yourapp.shared.entity.BaseEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {
    @Column(name = "full_name")
    String fullName;

    Short age;

    @Column(unique = true)
    String email;

    @OneToMany(mappedBy = "user")
    List<OrderEntity> orders;
}

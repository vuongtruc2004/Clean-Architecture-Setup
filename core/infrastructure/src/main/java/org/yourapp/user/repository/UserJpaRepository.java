package org.yourapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourapp.user.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}

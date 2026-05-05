package org.yourapp.user.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.yourapp.user.port.out.UserRepository;
import org.yourapp.user.repository.UserJpaRepository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existsById(Long id) {
        return userJpaRepository.existsById(id);
    }
}

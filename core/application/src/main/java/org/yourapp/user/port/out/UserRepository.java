package org.yourapp.user.port.out;

public interface UserRepository {
    boolean existsById(Long id);
}

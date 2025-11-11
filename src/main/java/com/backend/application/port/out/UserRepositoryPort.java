package com.backend.application.port.out;

import com.backend.domain.model.User;
import com.backend.domain.valueobject.Email;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(Email email);
    Optional<User> findById(UUID id);
}

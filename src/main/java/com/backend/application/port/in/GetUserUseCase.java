package com.backend.application.port.in;

import com.backend.domain.model.User;
import com.backend.domain.valueobject.Email;

import java.util.Optional;
import java.util.UUID;

public interface GetUserUseCase {
    Optional<User> getUserById(UUID id);
    Optional<User> getUserByEmail(Email email);
}

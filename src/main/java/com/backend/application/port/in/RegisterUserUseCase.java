package com.backend.application.port.in;

import com.backend.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(User user);
}

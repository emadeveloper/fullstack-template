package com.backend.application.port.in;

import com.backend.application.port.in.command.RegisterUserCommand;
import com.backend.application.dto.RegisterResponseDto;

public interface RegisterUserUseCase {
    RegisterResponseDto registerUser(RegisterUserCommand command);
}

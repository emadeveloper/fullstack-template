package com.backend.application.port.in.command;

import com.backend.domain.valueobject.Role;

import java.util.UUID;

public record UpdateUserCommand(
        UUID id,
        String email,
        String password,
        String role
) {}
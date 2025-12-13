package com.backend.application.dto;

import java.util.UUID;

public record RegisterResponseDto(
        UUID id,
        String email,
        String name,
        String role,
        String token
) {}

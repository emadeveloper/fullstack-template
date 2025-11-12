package com.backend.presentation.dto;

import com.backend.domain.valueobject.Email;

import java.util.UUID;

public record UserResponse(UUID id, Email email, String message) {}

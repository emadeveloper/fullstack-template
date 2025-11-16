package com.backend.presentation.dto;

import com.backend.domain.valueobject.Email;
import com.backend.domain.valueobject.Role;

public record RegisterUserRequest(String email, String password) {}

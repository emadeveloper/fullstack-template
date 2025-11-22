package com.backend.presentation.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError(
        int status,
        String message,
        Map<String, String> errors,
        LocalDateTime timeStamp
) {
    public ApiError(int status, String message) {
        this(status, message, null, LocalDateTime.now());
    }

    public ApiError(int status, String message, Map<String, String> errors) {
        this(status, message, errors, LocalDateTime.now());
    }
}

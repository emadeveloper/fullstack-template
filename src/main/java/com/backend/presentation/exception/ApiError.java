package com.backend.presentation.exception;

public record ApiError(int status, String message) {}

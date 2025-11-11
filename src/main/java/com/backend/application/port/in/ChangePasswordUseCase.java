package com.backend.application.port.in;

import java.util.UUID;

public interface ChangePasswordUseCase {
    void changePassword(UUID userId, String oldPassword, String newPassword);
}

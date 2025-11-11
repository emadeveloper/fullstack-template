package com.backend.application.port.out;

import com.backend.domain.valueobject.Email;

public interface NotificationPort {
    void sendWelcomeEmail(Email email, String message);
}

package com.backend.presentation.mapper;

import com.backend.application.port.in.command.RegisterUserCommand;
import com.backend.domain.model.User;
import com.backend.presentation.dto.RegisterUserRequest;
import com.backend.presentation.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserPresentationMapper {

    public RegisterUserCommand toCommand(RegisterUserRequest request) {
        return new RegisterUserCommand(
                request.email(),
                request.password(),
                request.role()
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                "Welcome to the Gym,  " + user.getEmail().getValue() + "!"
        );
    }
}
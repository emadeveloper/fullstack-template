package com.backend.presentation.controller;

import com.backend.application.port.in.RegisterUserUseCase;
import com.backend.application.port.in.command.RegisterUserCommand;

// TODO: This should not be from the domain, it really comes from a DTO from the application. Adjust Later
import com.backend.domain.model.User;

import com.backend.presentation.dto.RegisterUserRequest;
import com.backend.presentation.dto.UserResponse;
import com.backend.presentation.mapper.UserPresentationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserPresentationMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request) {

        // Convert DTO to Command for the use case
        RegisterUserCommand command = mapper.toCommand(request);

        // Execute the use case
        User user = registerUserUseCase.registerUser(command);

        // Map the domain to DTO from response
        UserResponse response = mapper.toResponse(user);

        // Return HTTP Status Code Response
        return ResponseEntity.ok(response);
    }


}

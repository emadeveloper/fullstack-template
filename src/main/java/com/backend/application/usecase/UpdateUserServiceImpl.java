package com.backend.application.usecase;

import com.backend.application.port.in.UpdateUserUseCase;
import com.backend.application.port.in.command.UpdateUserCommand;
import com.backend.application.port.out.UserRepositoryPort;
import com.backend.domain.model.User;
import com.backend.domain.valueobject.Email;
import com.backend.domain.valueobject.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepository;

    @Override
    public User updateUser(UpdateUserCommand command) {
        User existingUser = userRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + command.id()));

        existingUser.updateEmail(new Email(command.email()));
        existingUser.updatePassword(command.password());
        existingUser.updateRole(Role.valueOf(command.role()));

        return userRepository.save(existingUser);
    }
}

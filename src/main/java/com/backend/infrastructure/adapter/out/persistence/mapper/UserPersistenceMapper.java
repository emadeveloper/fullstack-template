package com.backend.infrastructure.adapter.out.persistence.mapper;

import com.backend.domain.model.User;
import com.backend.domain.valueobject.Email;
import com.backend.domain.valueobject.Role;
import com.backend.infrastructure.adapter.out.persistence.entity.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    public UserJpaEntity toEntity(User user) {
        return UserJpaEntity.builder()
                .id(user.getId())
                .email(user.getEmail().value())
                .password(user.getPassword())
                .role(user.getRole().name())
                .build();
    }

    public User toDomain(UserJpaEntity entity) {
        return new User(
                new Email(entity.getEmail()),
                entity.getPassword(),
                Role.valueOf(entity.getRole())
        );
    }

}

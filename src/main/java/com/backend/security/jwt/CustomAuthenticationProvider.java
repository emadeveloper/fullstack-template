package com.backend.security.jwt;

import com.backend.application.port.out.UserRepositoryPort;
import com.backend.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepositoryPort userRepository;    // port-out
    private final PasswordEncoder passwordEncoder;      // bean

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String rawPassword = String.valueOf(authentication.getCredentials());

        // load user by email (port -> adapter -> jpa)
        Optional<User> maybeUser = userRepository.findByEmail(email);
        if (maybeUser.isEmpty()) {
            throw new BadCredentialsException("Invalid credentials");
        }

        User user = maybeUser.get();

        // compare rawPassword (infrastructure must hash it)
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // 3) build Authentication with roles/authorities
        Collection<? extends GrantedAuthority> authorities = user.getRole() == null ?
                Collections.emptyList() :
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

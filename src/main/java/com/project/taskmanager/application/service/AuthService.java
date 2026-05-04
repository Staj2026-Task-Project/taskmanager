package com.project.taskmanager.application.service.impl;

import com.project.taskmanager.application.dto.request.UserLoginRequest;
import com.project.taskmanager.application.dto.response.AuthResponse;
import com.project.taskmanager.application.exception.UserNotFoundException;
import com.project.taskmanager.application.service.AuthService;
import com.project.taskmanager.domain.model.User;
import com.project.taskmanager.domain.repository.UserRepository;
import com.project.taskmanager.infrastructure.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public AuthResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!user.getIsActive()) {
            throw new RuntimeException("User account is inactive");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtProvider.generateToken(user.getUsername(), user.getRole().name());

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
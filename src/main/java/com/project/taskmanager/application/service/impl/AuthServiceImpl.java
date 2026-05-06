package com.project.taskmanager.application.service.impl;

import com.project.taskmanager.application.dto.request.LoginRequest;
import com.project.taskmanager.application.dto.request.RegisterRequest;
import com.project.taskmanager.application.dto.response.AuthResponse;
import com.project.taskmanager.application.service.AuthService;
import com.project.taskmanager.application.service.UserService;
import com.project.taskmanager.domain.model.User;
import com.project.taskmanager.infrastructure.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);

        return AuthResponse.builder()
                .token(jwt)
                .username(request.getUsername())
                .message("Login successful")
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userService.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                // İhtiyaca göre varsayılan roller eklenebilir
                .build();

        userService.saveUser(user);

        return AuthResponse.builder()
                .username(user.getUsername())
                .message("User registered successfully")
                .build();
    }
}
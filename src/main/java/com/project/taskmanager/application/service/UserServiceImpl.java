package com.project.taskmanager.application.service;

import com.project.taskmanager.application.dto.request.UserCreateRequest;
import com.project.taskmanager.application.dto.response.UserResponse;
import com.project.taskmanager.application.exception.UserNotFoundException;
import com.project.taskmanager.application.service.UserService;
import com.project.taskmanager.domain.model.User;
import com.project.taskmanager.domain.repository.UserRepository;
import com.project.taskmanager.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .isActive(true)
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setIsActive(false);
        user.setUpdatedAt(OffsetDateTime.now());
        userRepository.save(user);
    }
}
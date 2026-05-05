package com.project.taskmanager.application.service;

import com.project.taskmanager.application.dto.request.UserCreateRequest;
import com.project.taskmanager.application.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserCreateRequest request);
    UserResponse getUserById(Long id);
    UserResponse getUserByUsername(String username);
    void deleteUser(Long id);
}

//
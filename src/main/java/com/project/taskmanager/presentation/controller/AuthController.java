package com.project.taskmanager.presentation.controller;

import com.project.taskmanager.application.dto.request.LoginRequest;
import com.project.taskmanager.application.dto.request.RegisterRequest;
import com.project.taskmanager.application.dto.response.AuthResponse;
import com.project.taskmanager.application.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Auth API", description = "Kullanıcı kayıt ve kimlik doğrulama işlemleri")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Kullanıcı girişi", description = "Sisteme giriş yaparak JWT token alır.")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    @Operation(summary = "Yeni kullanıcı kaydı", description = "Sisteme yeni bir kullanıcı kaydeder.")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
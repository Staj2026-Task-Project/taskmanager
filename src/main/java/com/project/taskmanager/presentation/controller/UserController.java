package com.project.taskmanager.presentation.controller;

import com.project.taskmanager.application.service.UserService;
import com.project.taskmanager.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User API", description = "Kullanıcı işlemleri ve yönetimi")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Kullanıcı getir", description = "ID değerine göre kullanıcının temel detaylarını getirir.")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
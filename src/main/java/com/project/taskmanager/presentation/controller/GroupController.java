package com.project.taskmanager.presentation.controller;

import com.project.taskmanager.application.service.GroupService;
import com.project.taskmanager.domain.model.Group;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@Tag(name = "Group API", description = "Grup ve takım yönetimi işlemleri")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Yeni grup oluştur", description = "Sisteme yeni bir grup/takım ekler. Sadece ADMIN yetkisi gerektirir.")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.createGroup(group), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Grup getir", description = "ID değerine göre grubun detaylarını getirir.")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }
}
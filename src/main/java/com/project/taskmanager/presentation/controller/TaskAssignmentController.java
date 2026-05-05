package com.project.taskmanager.presentation.controller;

import com.project.taskmanager.application.dto.request.TaskAssignRequest;
import com.project.taskmanager.application.dto.request.TaskStateUpdateRequest;
import com.project.taskmanager.application.dto.response.TaskAssignmentResponse;
import com.project.taskmanager.application.service.TaskAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task-assignments")
@RequiredArgsConstructor
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    @PostMapping("/assign")
    public ResponseEntity<TaskAssignmentResponse> assignTask(@RequestBody TaskAssignRequest request) {
        TaskAssignmentResponse response = taskAssignmentService.assignTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/state")
    public ResponseEntity<TaskAssignmentResponse> updateTaskState(@RequestBody TaskStateUpdateRequest request) {
        TaskAssignmentResponse response = taskAssignmentService.updateTaskState(request);
        return ResponseEntity.ok(response);
    }
}
//
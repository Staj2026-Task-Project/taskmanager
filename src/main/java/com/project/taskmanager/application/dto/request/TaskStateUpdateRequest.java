package com.project.taskmanager.application.dto.request;

import com.project.taskmanager.domain.enums.TaskState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStateUpdateRequest {
    private Long taskAssignmentId;
    private TaskState newState;
    private Long userId;
}
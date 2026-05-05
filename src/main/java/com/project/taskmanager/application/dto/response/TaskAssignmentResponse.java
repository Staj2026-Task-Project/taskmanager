package com.project.taskmanager.application.dto.response;

import com.project.taskmanager.domain.enums.TaskState;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskAssignmentResponse {
    private Long id;
    private Long taskId;
    private Long userId;
    private Long groupId;
    private TaskState taskState;
    private Boolean penaltyApplied;
    private OffsetDateTime completedAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
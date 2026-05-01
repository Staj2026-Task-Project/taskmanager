package com.project.taskmanager.application.dto.response;

import com.project.taskmanager.domain.enums.AssignmentRule;
import com.project.taskmanager.domain.enums.TaskPriority;
import com.project.taskmanager.domain.enums.TaskState;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskPriority priority;
    private AssignmentRule assignmentRule;
    private OffsetDateTime dueDate;
    private TaskState status;
    private Long createdBy;
    private Boolean isActive;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
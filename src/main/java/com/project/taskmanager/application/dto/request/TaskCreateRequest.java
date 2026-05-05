package com.project.taskmanager.application.dto.request;

import com.project.taskmanager.domain.enums.AssignmentRule;
import com.project.taskmanager.domain.enums.TaskPriority;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskCreateRequest {
    private String title;
    private String description;
    private TaskPriority priority;
    private AssignmentRule assignmentRule;
    private OffsetDateTime dueDate;
    private Long createdBy;
}
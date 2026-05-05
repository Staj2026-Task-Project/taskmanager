package com.project.taskmanager.domain.model;

import com.project.taskmanager.domain.enums.AssignmentRule;
import com.project.taskmanager.domain.enums.TaskPriority;
import com.project.taskmanager.domain.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
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
    private Long version;
}
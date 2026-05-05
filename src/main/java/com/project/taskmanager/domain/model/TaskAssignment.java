package com.project.taskmanager.domain.model;

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
public class TaskAssignment {
    private Long id;
    private Long taskId;
    private Long userId;
    private Long groupId;
    private TaskState taskState;
    private Boolean penaltyApplied;
    private OffsetDateTime completedAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long version;
}
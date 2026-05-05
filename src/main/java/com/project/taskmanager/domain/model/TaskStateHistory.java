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
public class TaskStateHistory {
    private Long id;
    private Long taskAssignmentId;
    private TaskState previousState;
    private TaskState newState;
    private Long changedBy;
    private OffsetDateTime changedAt;
    private Long version;
}
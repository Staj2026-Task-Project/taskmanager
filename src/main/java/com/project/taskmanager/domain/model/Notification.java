package com.project.taskmanager.domain.model;

import com.project.taskmanager.domain.enums.NotificationType;
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
public class Notification {
    private Long id;
    private Long userId;
    private Long taskAssignmentId;
    private NotificationType notificationType;
    private String message;
    private Boolean isRead;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long version;
}
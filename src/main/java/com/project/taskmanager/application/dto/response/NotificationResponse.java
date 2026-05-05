package com.project.taskmanager.application.dto.response;

import com.project.taskmanager.domain.enums.NotificationType;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class NotificationResponse {
    private Long id;
    private Long userId;
    private Long taskAssignmentId;
    private NotificationType notificationType;
    private String message;
    private Boolean isRead;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
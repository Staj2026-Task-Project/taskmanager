package com.project.taskmanager.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskAssignRequest {
    private Long taskId;
    private Long userId;
    private Long groupId;
}
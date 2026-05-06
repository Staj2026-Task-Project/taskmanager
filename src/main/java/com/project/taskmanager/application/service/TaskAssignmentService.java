package com.project.taskmanager.application.service;

import com.project.taskmanager.application.dto.request.TaskAssignRequest;
import com.project.taskmanager.application.dto.request.TaskStateUpdateRequest;
import com.project.taskmanager.application.dto.response.TaskAssignmentResponse;

public interface TaskAssignmentService {
    TaskAssignmentResponse assignTask(TaskAssignRequest request);
    TaskAssignmentResponse updateTaskState(TaskStateUpdateRequest request);
    void applyPenaltiesForOverdueTasks();
}

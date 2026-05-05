package com.project.taskmanager.domain.repository;

import com.project.taskmanager.domain.model.TaskStateHistory;

import java.util.List;
import java.util.Optional;

public interface TaskStateHistoryRepository {
    TaskStateHistory save(TaskStateHistory taskStateHistory);
    Optional<TaskStateHistory> findById(Long id);
    List<TaskStateHistory> findByTaskAssignmentId(Long taskAssignmentId);
}
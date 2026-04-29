package com.project.taskmanager.domain.repository;

import com.project.taskmanager.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    Optional<Task> findActiveById(Long id);
    List<Task> findAllActive();
    void delete(Long id);
}
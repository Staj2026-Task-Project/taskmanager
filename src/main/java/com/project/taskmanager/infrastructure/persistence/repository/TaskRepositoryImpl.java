package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.domain.model.Task;
import com.project.taskmanager.domain.repository.TaskRepository;
import com.project.taskmanager.infrastructure.mapper.TaskMapper;
import com.project.taskmanager.infrastructure.persistence.entity.TaskEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.TaskJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskJpaRepository taskJpaRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        TaskEntity savedEntity = taskJpaRepository.save(entity);
        return taskMapper.toModel(savedEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskJpaRepository.findById(id)
                .map(taskMapper::toModel);
    }
}
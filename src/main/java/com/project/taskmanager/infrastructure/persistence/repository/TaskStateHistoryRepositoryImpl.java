package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.domain.model.TaskStateHistory;
import com.project.taskmanager.domain.repository.TaskStateHistoryRepository;
import com.project.taskmanager.infrastructure.mapper.TaskStateHistoryMapper;
import com.project.taskmanager.infrastructure.persistence.entity.TaskStateHistoryEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.TaskStateHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskStateHistoryRepositoryImpl implements TaskStateHistoryRepository {

    private final TaskStateHistoryJpaRepository taskStateHistoryJpaRepository;
    private final TaskStateHistoryMapper taskStateHistoryMapper;

    @Override
    public TaskStateHistory save(TaskStateHistory taskStateHistory) {
        TaskStateHistoryEntity entity = taskStateHistoryMapper.toEntity(taskStateHistory);
        TaskStateHistoryEntity savedEntity = taskStateHistoryJpaRepository.save(entity);
        return taskStateHistoryMapper.toModel(savedEntity);
    }
}
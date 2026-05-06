package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.domain.model.TaskAssignment;
import com.project.taskmanager.domain.repository.TaskAssignmentRepository;
import com.project.taskmanager.infrastructure.mapper.TaskAssignmentMapper;
import com.project.taskmanager.infrastructure.persistence.entity.TaskAssignmentEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.TaskAssignmentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskAssignmentRepositoryImpl implements TaskAssignmentRepository {

    private final TaskAssignmentJpaRepository taskAssignmentJpaRepository;
    private final TaskAssignmentMapper taskAssignmentMapper;

    @Override
    public TaskAssignment save(TaskAssignment taskAssignment) {
        TaskAssignmentEntity entity = taskAssignmentMapper.toEntity(taskAssignment);
        TaskAssignmentEntity savedEntity = taskAssignmentJpaRepository.save(entity);
        return taskAssignmentMapper.toModel(savedEntity);
    }

    @Override
    public Optional<TaskAssignment> findById(Long id) {
        return taskAssignmentJpaRepository.findById(id)
                .map(taskAssignmentMapper::toModel);
    }

    @Override
    public List<TaskAssignment> findByTaskId(Long taskId) {
        return taskAssignmentJpaRepository.findByTaskId(taskId)
                .stream()
                .map(taskAssignmentMapper::toModel)
                .collect(Collectors.toList());
    }
}
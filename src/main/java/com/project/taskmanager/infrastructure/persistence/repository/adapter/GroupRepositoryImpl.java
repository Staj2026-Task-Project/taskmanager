package com.project.taskmanager.infrastructure.persistence.repository.adapter;

import com.project.taskmanager.domain.model.Group;
import com.project.taskmanager.domain.repository.GroupRepository;
import com.project.taskmanager.infrastructure.mapper.GroupMapper;
import com.project.taskmanager.infrastructure.persistence.entity.GroupEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.GroupJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {

    private final GroupJpaRepository groupJpaRepository;
    private final GroupMapper groupMapper;

    @Override
    public Group save(Group group) {
        GroupEntity entity = groupMapper.toEntity(group);
        GroupEntity savedEntity = groupJpaRepository.save(entity);
        return groupMapper.toModel(savedEntity);
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupJpaRepository.findById(id)
                .map(groupMapper::toModel);
    }
}
package com.project.taskmanager.infrastructure.persistence.repository.adapter;

import com.project.taskmanager.domain.model.UserGroup;
import com.project.taskmanager.domain.repository.UserGroupRepository;
import com.project.taskmanager.infrastructure.mapper.UserGroupMapper;
import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.UserGroupJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserGroupRepositoryImpl implements UserGroupRepository {

    private final UserGroupJpaRepository userGroupJpaRepository;
    private final UserGroupMapper userGroupMapper;

    @Override
    public UserGroup save(UserGroup userGroup) {
        UserGroupEntity entity = userGroupMapper.toEntity(userGroup);
        UserGroupEntity savedEntity = userGroupJpaRepository.save(entity);
        return userGroupMapper.toModel(savedEntity);
    }

    @Override
    public List<UserGroup> findByUserId(Long userId) {
        return userGroupJpaRepository.findByUserId(userId)
                .stream()
                .map(userGroupMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserGroup> findByGroupId(Long groupId) {
        return userGroupJpaRepository.findByGroupId(groupId)
                .stream()
                .map(userGroupMapper::toModel)
                .collect(Collectors.toList());
    }
}
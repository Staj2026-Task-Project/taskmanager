package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.domain.model.UserGroup;
import com.project.taskmanager.domain.repository.UserGroupRepository;
import com.project.taskmanager.infrastructure.mapper.UserGroupMapper;
import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserGroupRepositoryImpl implements UserGroupRepository {

    private final UserGroupJpaRepository jpaRepository;
    private final UserGroupMapper userGroupMapper;

    @Override
    public UserGroup save(UserGroup userGroup) {
        UserGroupEntity entity = userGroupMapper.toEntity(userGroup);
        UserGroupEntity savedEntity = jpaRepository.save(entity);
        return userGroupMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<UserGroup> findById(Long id) {
        return jpaRepository.findByIdAndIsActiveTrue(id)
                .map(userGroupMapper::toDomain);
    }

    @Override
    public List<UserGroup> findByUserId(Long userId) {
        return jpaRepository.findByUserIdAndIsActiveTrue(userId).stream()
                .map(userGroupMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserGroup> findByGroupId(Long groupId) {
        return jpaRepository.findByGroupIdAndIsActiveTrue(groupId).stream()
                .map(userGroupMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserGroup> findByUserIdAndGroupIdAndIsActiveTrue(Long userId, Long groupId) {
        return jpaRepository.findByUserIdAndGroupIdAndIsActiveTrue(userId, groupId)
                .map(userGroupMapper::toDomain);
    }
}
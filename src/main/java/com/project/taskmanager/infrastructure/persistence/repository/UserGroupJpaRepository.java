package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupJpaRepository extends JpaRepository<UserGroupEntity, Long> {
    Optional<UserGroupEntity> findByIdAndIsActiveTrue(Long id);
    List<UserGroupEntity> findByUserIdAndIsActiveTrue(Long userId);
    List<UserGroupEntity> findByGroupIdAndIsActiveTrue(Long groupId);
    Optional<UserGroupEntity> findByUserIdAndGroupIdAndIsActiveTrue(Long userId, Long groupId);
}
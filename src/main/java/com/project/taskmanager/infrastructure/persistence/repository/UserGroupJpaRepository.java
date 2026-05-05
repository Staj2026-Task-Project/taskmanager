package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupJpaRepository extends JpaRepository<UserGroupEntity, Long> {
    List<UserGroupEntity> findByUserId(Long userId);
    List<UserGroupEntity> findByGroupId(Long groupId);
}
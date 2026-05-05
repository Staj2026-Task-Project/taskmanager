package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.infrastructure.persistence.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupJpaRepository extends JpaRepository<GroupEntity, Long> {
}
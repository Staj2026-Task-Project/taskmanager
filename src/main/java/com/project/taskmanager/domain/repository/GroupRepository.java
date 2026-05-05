package com.project.taskmanager.domain.repository;

import com.project.taskmanager.domain.model.Group;
import java.util.Optional;

public interface GroupRepository {
    Group save(Group group);
    Optional<Group> findById(Long id);
    Optional<Group> findByName(String name);
}
//
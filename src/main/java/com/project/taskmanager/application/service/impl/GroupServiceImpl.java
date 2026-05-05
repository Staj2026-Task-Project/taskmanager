package com.project.taskmanager.application.service.impl;

import com.project.taskmanager.application.service.GroupService;
import com.project.taskmanager.domain.model.Group;
import com.project.taskmanager.domain.repository.GroupRepository;
import com.project.taskmanager.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + id));
    }
}
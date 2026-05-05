package com.project.taskmanager.application.service;

import com.project.taskmanager.application.dto.request.GroupCreateRequest;
import com.project.taskmanager.application.dto.request.UserGroupAddRequest;
import com.project.taskmanager.application.dto.response.GroupResponse;

public interface GroupService {
    GroupResponse createGroup(GroupCreateRequest request, Long adminId);
    GroupResponse getGroupById(Long id);
    void addUserToGroup(UserGroupAddRequest request);
    void removeUserFromGroup(Long userId, Long groupId);
    void deleteGroup(Long id);
}

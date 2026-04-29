package com.project.taskmanager.domain.repository;

import com.project.taskmanager.domain.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> findById(Long id);
    List<Notification> findByUserId(Long userId);
    List<Notification> findUnreadByUserId(Long userId);
}
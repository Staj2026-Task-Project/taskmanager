package com.project.taskmanager.infrastructure.persistence.repository;

import com.project.taskmanager.domain.model.Notification;
import com.project.taskmanager.domain.repository.NotificationRepository;
import com.project.taskmanager.infrastructure.mapper.NotificationMapper;
import com.project.taskmanager.infrastructure.persistence.entity.NotificationEntity;
import com.project.taskmanager.infrastructure.persistence.repository.jpa.NotificationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationJpaRepository notificationJpaRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public Notification save(Notification notification) {
        NotificationEntity entity = notificationMapper.toEntity(notification);
        NotificationEntity savedEntity = notificationJpaRepository.save(entity);
        return notificationMapper.toModel(savedEntity);
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationJpaRepository.findById(id)
                .map(notificationMapper::toModel);
    }
}
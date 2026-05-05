package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.domain.model.Notification;
import com.project.taskmanager.infrastructure.persistence.entity.NotificationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationEntityMapper {
    Notification toModel(NotificationEntity entity);
    NotificationEntity toEntity(Notification model);
}
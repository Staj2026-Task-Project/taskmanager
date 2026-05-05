package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.domain.model.User;
import com.project.taskmanager.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserEntity entity);
    UserEntity toEntity(User model);
}
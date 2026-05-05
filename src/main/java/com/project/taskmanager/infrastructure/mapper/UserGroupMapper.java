package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.domain.model.UserGroup;
import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGroupMapper {
    UserGroup toModel(UserGroupEntity entity);
    UserGroupEntity toEntity(UserGroup model);
}
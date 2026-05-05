package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.domain.model.UserGroup;
import com.project.taskmanager.infrastructure.persistence.entity.UserGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserGroupMapper {

    UserGroupEntity toEntity(UserGroup domain);

    UserGroup toDomain(UserGroupEntity entity);
}
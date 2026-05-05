package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.domain.model.Group;
import com.project.taskmanager.infrastructure.persistence.entity.GroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    Group toModel(GroupEntity entity);
    GroupEntity toEntity(Group model);
}
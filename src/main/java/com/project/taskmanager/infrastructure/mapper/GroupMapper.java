package com.project.taskmanager.infrastructure.mapper;

import com.project.taskmanager.application.dto.response.GroupResponse;
import com.project.taskmanager.domain.model.Group;
import com.project.taskmanager.infrastructure.persistence.entity.GroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroupMapper {

    GroupEntity toEntity(Group domain);

    Group toDomain(GroupEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "isActive", source = "isActive")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    GroupResponse toResponse(Group domain);
}
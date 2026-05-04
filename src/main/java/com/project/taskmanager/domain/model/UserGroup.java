package com.project.taskmanager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroup {
    private Long id;
    private Long userId;
    private Long groupId;
    private Boolean isActive;
    private OffsetDateTime joinedAt;
    private OffsetDateTime leftAt;
}
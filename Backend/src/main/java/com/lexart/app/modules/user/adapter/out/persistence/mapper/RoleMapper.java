package com.lexart.app.modules.user.adapter.out.persistence.mapper;

import com.lexart.app.modules.user.domain.enums.ERole;
import com.lexart.app.modules.user.adapter.out.persistence.entity.RoleEntity;
import com.lexart.app.modules.user.domain.model.Role;

public class RoleMapper {

    public static RoleEntity mapToEntity(Role role) {
        if (role == null) {
            return null;
        }

        return RoleEntity.builder()
                .id(role.getId())
                .name(ERole.valueOf(role.getName()))
                .build();
    }
    public static Role mapToDomain(RoleEntity roleEntity) {
        if (roleEntity == null) {
            return null;
        }

        return Role.builder()
                .id(roleEntity.getId())
                .name(String.valueOf(roleEntity.getName()))
                .build();
    }




}

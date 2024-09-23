package com.lexart.app.modules.user.adapter.out.persistence.mapper;

import com.lexart.app.modules.user.adapter.in.web.dto.UserDTO;
import com.lexart.app.modules.user.adapter.out.persistence.entity.RoleEntity;
import com.lexart.app.modules.user.adapter.out.persistence.entity.UserEntity;
import com.lexart.app.modules.user.domain.model.Role;
import com.lexart.app.modules.user.domain.model.User;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO mapToDTOWithoutCredentials(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;

    }
    public static UserEntity mapToEntity(User user) {
        if (user == null) {
            return null;
        }

        Set<RoleEntity> roleEntities = user.getRoles() != null ?
                user.getRoles().stream()
                        .map(RoleMapper::mapToEntity)
                        .collect(Collectors.toSet()) :
                Collections.emptySet();

        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roleEntities)
                .build();
    }


    public static User mapToDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        if(userEntity.getRoles() != null){
            Set<Role> roles = userEntity.getRoles() != null ?
                    userEntity.getRoles().stream()
                            .map(RoleMapper::mapToDomain)
                            .collect(Collectors.toSet()) :
                    Collections.emptySet();
        user.setRoles(roles);
        }
        return user;
    }

    public static User mapToDomain(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        if (userDTO.getRoles() != null) {
            Set<Role> roles = userDTO.getRoles().stream()
                    .map(roleName -> {
                        Role role = new Role();
                        role.setName(roleName);
                        return role;
                    })
                    .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        return user;
    }



}


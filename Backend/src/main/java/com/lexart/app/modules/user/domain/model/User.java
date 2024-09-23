package com.lexart.app.modules.user.domain.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Set<Role> roles;
}

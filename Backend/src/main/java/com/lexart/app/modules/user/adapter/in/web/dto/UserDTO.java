package com.lexart.app.modules.user.adapter.in.web.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Set<String> roles;

}

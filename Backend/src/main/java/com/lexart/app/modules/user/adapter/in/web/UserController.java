package com.lexart.app.modules.user.adapter.in.web;

import com.lexart.app.modules.user.application.port.in.GetUserByIdUseCase;
import com.lexart.app.modules.user.domain.model.User;
import com.lexart.app.modules.user.adapter.in.web.dto.UserDTO;
import com.lexart.app.modules.user.adapter.out.persistence.mapper.UserMapper;
import com.lexart.app.modules.user.application.port.in.CreateUserUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }


    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = getUserByIdUseCase.getUserById(id);
        return UserMapper.mapToDTOWithoutCredentials(user);
    }



}
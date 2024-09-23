package com.lexart.app.modules.user.adapter.in.web;


import com.lexart.app.modules.user.domain.model.User;
import com.lexart.app.modules.user.adapter.in.web.dto.UserDTO;
import com.lexart.app.modules.user.adapter.out.persistence.mapper.UserMapper;
import com.lexart.app.modules.user.application.port.in.CreateUserUseCase;
import com.lexart.app.modules.user.domain.exception.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;



    public AuthController( CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }


    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        try {
            User user = UserMapper.mapToDomain(userDTO);
            createUserUseCase.createUser(user);
        } catch (UsernameAlreadyExistsException ex) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
        return null;
    }


}

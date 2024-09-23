package com.lexart.app.modules.user.application.service;

import com.lexart.app.modules.user.application.port.out.UserRepository;
import com.lexart.app.modules.user.application.port.in.CreateUserUseCase;
import com.lexart.app.modules.user.application.port.in.GetUserByIdUseCase;
import com.lexart.app.modules.user.domain.exception.UserNotFoundException;
import com.lexart.app.modules.user.domain.exception.UsernameAlreadyExistsException;
import com.lexart.app.modules.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService implements CreateUserUseCase, GetUserByIdUseCase {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UsernameAlreadyExistsException(user.getUsername());
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }



}
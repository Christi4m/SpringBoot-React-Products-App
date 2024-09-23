package com.lexart.app.modules.user.application.port.out;

import com.lexart.app.modules.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> getById(Long id);

    Optional<User> getByUsername(String username);

}

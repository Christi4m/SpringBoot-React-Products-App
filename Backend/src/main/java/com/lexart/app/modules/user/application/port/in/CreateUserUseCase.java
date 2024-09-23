package com.lexart.app.modules.user.application.port.in;

import com.lexart.app.modules.user.domain.model.User;

public interface CreateUserUseCase {
    void createUser(User user);
}
package com.lexart.app.modules.user.domain.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super("Usuario '" + username + "' ya existe en el sistema.");
    }
}
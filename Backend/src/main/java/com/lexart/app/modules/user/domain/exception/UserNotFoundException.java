package com.lexart.app.modules.user.domain.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("No se encontró el usuario con ID: " + id);
    }

    public UserNotFoundException(String username) {
        super("No se encontró el usuario con nombre de usuario: " + username);
    }
}

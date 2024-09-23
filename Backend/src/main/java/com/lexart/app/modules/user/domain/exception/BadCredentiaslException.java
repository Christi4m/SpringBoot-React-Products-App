package com.lexart.app.modules.user.domain.exception;

public class BadCredentiaslException  extends RuntimeException {
    public BadCredentiaslException(String username) {
        super("Credenciales invalidas para el usuario: " + username);
    }

}

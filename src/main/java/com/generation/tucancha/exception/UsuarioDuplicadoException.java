package com.generation.tucancha.exception;

public class UsuarioDuplicadoException extends RuntimeException {

    public UsuarioDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
package com.spring.evaluacion.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
        super("El correo ya está registrado");
    }
}

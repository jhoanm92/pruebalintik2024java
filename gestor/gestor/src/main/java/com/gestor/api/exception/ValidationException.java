package com.gestor.api.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String mensaje){
        super(mensaje);
    }
}

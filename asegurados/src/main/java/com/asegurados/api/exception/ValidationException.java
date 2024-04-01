package com.asegurados.api.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String mensaje){
        super(mensaje);
    }
}

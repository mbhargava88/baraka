package com.baraka.exceptions;


import com.baraka.validators.Errors;

public class InvalidRequestException extends RuntimeException{

    private Errors errors;

    public InvalidRequestException(Errors errors) {
        this.errors = errors;
    }

    public InvalidRequestException() {}

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}

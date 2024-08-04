package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmailValidationException extends RuntimeException{

    public EmailValidationException(String email){
        super("Email: " + email + " is not in a valid format. Please add a valid email!");
    }

    public EmailValidationException() {
    }
}

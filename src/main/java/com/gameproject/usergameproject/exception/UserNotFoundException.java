package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not found the user with name:" + id);
    }

    public UserNotFoundException() {
    }
}

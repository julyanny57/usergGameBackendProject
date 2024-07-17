package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserByNameAndPasswordNotFoundException extends RuntimeException{

    public UserByNameAndPasswordNotFoundException(String username){
        super("Could not found the user with name: " + username);
    }

    public UserByNameAndPasswordNotFoundException() {
    }
}

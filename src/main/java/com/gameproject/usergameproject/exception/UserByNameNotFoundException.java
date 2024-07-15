package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserByNameNotFoundException extends RuntimeException{

    public UserByNameNotFoundException(String username){
        super("Could not found the user with name:" + username);
    }

    public UserByNameNotFoundException() {
    }
}

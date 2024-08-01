package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserByNameExistsException extends RuntimeException{

    public UserByNameExistsException(String username){
        super("The user with name: " + username + " already exists. Please try another one.");
    }

    public UserByNameExistsException() {
    }
}

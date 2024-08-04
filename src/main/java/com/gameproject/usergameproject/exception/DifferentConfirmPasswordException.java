package com.gameproject.usergameproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class DifferentConfirmPasswordException extends RuntimeException{

    public DifferentConfirmPasswordException(){
        super("Confirm password doesn't match the initial password. Please try one more time!");
    }

//    public DifferentConfirmPasswordException() {
//    }
}

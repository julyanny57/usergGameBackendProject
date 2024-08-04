package com.gameproject.usergameproject.service.impl;

import com.gameproject.usergameproject.service.GameUserService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class GameUserServiceImpl implements GameUserService {

    public Boolean emailValidation(String email){
        System.out.println("Email validation here!!!!!");
        String emailRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches()){
            return true;
        }
        else {
            return false;
        }
    }

}

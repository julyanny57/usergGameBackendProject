package com.gameproject.usergameproject.controller;

import com.gameproject.usergameproject.exception.*;
import com.gameproject.usergameproject.model.User;
import com.gameproject.usergameproject.repository.UserRepository;
import com.gameproject.usergameproject.service.GameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private GameUserService gameUserService;
    public UserController(GameUserService gameUserService) {
        this.gameUserService = gameUserService;
    }

    @PostMapping("/adduser")
    User newUser(@RequestBody User newUser){
        User existingUser = userRepository.findByUsername(newUser.getUsername());
        if(existingUser != null){
            throw new UserByNameExistsException(newUser.getUsername());
        }
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())){
            throw new DifferentConfirmPasswordException();
        }
        if(!gameUserService.emailValidation(newUser.getEmail())){
            throw new EmailValidationException(newUser.getEmail());
        }
        else
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @GetMapping("/loginUser/{username}&&{password}")
    User getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password){
        User existingUser = userRepository.findByUsernameAndPassword(username, password);
        if(existingUser == null){
            throw new UserByNameAndPasswordNotFoundException(username);
        }
        return existingUser;
    }

}

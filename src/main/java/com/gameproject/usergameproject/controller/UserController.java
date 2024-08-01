package com.gameproject.usergameproject.controller;

import com.gameproject.usergameproject.exception.UserByNameAndPasswordNotFoundException;
import com.gameproject.usergameproject.exception.UserByNameExistsException;
import com.gameproject.usergameproject.exception.UserNotFoundException;
import com.gameproject.usergameproject.model.User;
import com.gameproject.usergameproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
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

    @GetMapping("/username/{username}&&{password}")
    User getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password){
        User existingUser = userRepository.findByUsernameAndPassword(username, password);
        if(existingUser == null){
            throw new UserByNameAndPasswordNotFoundException(username);
        }
        return existingUser;
    }

    @GetMapping("/username/{username}")
    User getUserByUsername(@PathVariable String username){
        User existingUser = userRepository.findByUsername(username);
        if(existingUser != null){
            throw new UserByNameExistsException(username);
        }
        return existingUser;
    }

}

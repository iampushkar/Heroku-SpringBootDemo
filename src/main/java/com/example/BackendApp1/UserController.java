package com.example.BackendApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    //adding a user
    @PostMapping("/user")
    public boolean addUser(@RequestBody User user) {
        userRepository.save(user);
        return true;
    }

    
}

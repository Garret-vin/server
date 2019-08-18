package com.garret.server.controller;

import com.garret.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/hashPassword")
    public User hashPassword(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}

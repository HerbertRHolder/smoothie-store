package com.store.smoothies.controllers;

import com.store.smoothies.repositories.UserRepository;
import com.store.smoothies.models.User;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class Login {

    // Declared an instance variable of type UserRepository //
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor that accepts a UserRepository object and assigns it to the instance variable to access methods //
    @Autowired
    public Login(UserRepository userRepository, PasswordEncoder encoder ) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }
    @GetMapping("/login")
    public String displayLoginPage(){ return "login";}






    }// end login controller


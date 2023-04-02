package com.store.smoothies.controllers;

import com.store.smoothies.repositories.UserRepository;
import com.store.smoothies.models.User;



import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    private final UserRepository userRepository;


    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
        public String displayLoginPage(){
            return "login";
        }

    }// end login controller


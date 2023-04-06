package com.store.smoothies.controllers;


import com.store.smoothies.models.User;
import com.store.smoothies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profile {

    private final UserRepository users;

    @Autowired
    public Profile(UserRepository us){
        this.users = us;
    }


    @GetMapping("/profile")
    public String displayRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "profile";
    }
}

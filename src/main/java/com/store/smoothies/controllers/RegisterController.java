package com.store.smoothies.controllers;

import com.store.smoothies.models.User;
import com.store.smoothies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmail(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "An account with this email already exists");
            return "register";
        }
        // Password validation
        String password = user.getPassword();
        if (password == null || password.length() < 8) {
            model.addAttribute("error", "Password must be at least 8 characters long and must contain at least one symbol");
            return "register";
        } else if (!password.matches(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
            model.addAttribute("error", "Password must be at least 8 characters long and must contain at least one symbol");
            return "register";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/login";
    }
}

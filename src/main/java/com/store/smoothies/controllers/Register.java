package com.store.smoothies.controllers;

import com.store.smoothies.models.User;
import com.store.smoothies.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class Register {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    // constructor dependency injection
    public Register(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder)
    {
        this.repository = userRepository;
        this.encoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) throws StripeException {
        User existingUser = this.repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "An account with this email already exists");
            return "register";
        }
        // Password validation
        String password = user.getPassword();
        if (password == null || password.length() < 4) {
            model.addAttribute("error", "Password must be at least 8 characters long and must contain at least one symbol");
            return "register";
        }
        String encodedPassword = this.encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Map<String, Object> meta = new HashMap<>();
        meta.put("first_name", user.getFirstName());
        meta.put("last_name",user.getLastName());
        meta.put( "email",user.getUsername());


        Customer c = Customer.create(meta);
        user.setCustomer_id(c.getId());

        this.repository.save(user);
        return "redirect:/login";
    }


} // end controller

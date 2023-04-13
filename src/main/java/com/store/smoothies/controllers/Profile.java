package com.store.smoothies.controllers;


import com.store.smoothies.models.User;
import com.store.smoothies.services.UserDetailsLoader;
//import com.store.smoothies.services.UserService;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.store.smoothies.repositories.UserRepository;
import com.stripe.param.ChargeListParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Profile {

    private final UserRepository repo;
    private Customer customer;
    @Value("${STRIPE_API_SECRET}")
    private String stripeSecretKey;
    @Value("${STRIPE_API_PKEY}")
    private String stripePublicKey;

    @Autowired
    public Profile(UserRepository ur){
        this.repo = ur;
    }




}


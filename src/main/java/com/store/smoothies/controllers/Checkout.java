package com.store.smoothies.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Checkout {


    @GetMapping("/checkout")
    public String displayCheckoutPage(){
        return "checkout";
    }

}

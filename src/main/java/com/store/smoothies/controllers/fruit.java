package com.store.smoothies.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class fruit {
    @GetMapping("/fruit")
    public String displayHomePage(Model model){
        return "fruits";
    }

}

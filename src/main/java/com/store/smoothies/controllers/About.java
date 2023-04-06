package com.store.smoothies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class About {

        @GetMapping("/about")
        public String displayAboutPage(Model model){
            return "about";
        }



}

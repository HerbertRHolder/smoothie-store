package com.store.smoothies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Home {
        @GetMapping("/")
        public String displayHomePage(Model model){
            return "index";
        }

}

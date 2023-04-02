package com.store.smoothies.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class successController {

    @GetMapping("/success")
    public String displaySuccessPage(){
        return "success";
    }
}

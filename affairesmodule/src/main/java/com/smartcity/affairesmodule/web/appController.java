package com.smartcity.affairesmodule.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appController {

    @GetMapping("/home")
    public String home(Model model) {
        return "app/home";
    }
}
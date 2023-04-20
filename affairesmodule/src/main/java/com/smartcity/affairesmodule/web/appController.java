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

    @GetMapping("/historique")
    public String historique(Model model) {

        return "app/historique";
    }
    @GetMapping("/entreprises")
    public String entreprises(Model model) {

        return "app/entreprises";
    }

    @GetMapping("/affaires")
    public String affaires(Model model) {
        return "app/affaires";
    }
    @GetMapping("/gallerie")
    public String gallerie(Model model) {
        return "app/gallerie";
    }
    @GetMapping("/contact_us")
    public String contactus(Model model) {
        return "app/contactus";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        return "app/profile";
    }
    @GetMapping("/edit_profile/id")
    public String edit_profile(Model model) {
        return "app/profile_edit";
    }
    @GetMapping("/loginn")
    public String login(Model model) {
        return "app/login";
    }

}

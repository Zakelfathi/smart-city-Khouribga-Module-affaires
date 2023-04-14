package com.smartcity.affairesmodule.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dashboardController {

    @RequestMapping(value = "/admin/dashboard")
    public String index(Model model) {
        model.addAttribute("activePage", "dashboard");
        return "dashboard/home";
    }

}

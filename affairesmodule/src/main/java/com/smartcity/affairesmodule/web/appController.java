package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartcity.affairesmodule.repositories.VilleRepository;
import com.smartcity.affairesmodule.repositories.EntrepriseRepository;


import java.util.List;
import java.util.Optional;

@Controller
public class appController {

    @Autowired
    private VilleRepository VilleRepository;
    @Autowired
    private EntrepriseRepository EntrepriseRepository;

    @GetMapping("/home")
    public String home(Model model) {
        return "app/home";
    }

    @GetMapping("/historique")
    public String historique(Model model) {

        return "app/historique";
    }
    @GetMapping("/entreprises")
    public String entreprises(Model model,
                              @RequestParam(name="page", defaultValue="0") int page,
                              @RequestParam(name="size", defaultValue="5") int size,
                              @RequestParam(name="nom", defaultValue="") String nom) {

        Optional<ville> ville = VilleRepository.findById(1L); // get the ville with id=1(khouribga)
        List<entreprise> entreprises = EntrepriseRepository.findByVille(ville); // get the entreprises related to the ville
        model.addAttribute("entreprises", entreprises);

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

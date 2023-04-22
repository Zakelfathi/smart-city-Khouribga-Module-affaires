package com.smartcity.affairesmodule.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.RequestParam;
import com.smartcity.affairesmodule.repositories.VilleRepository;
import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Optional;
>>>>>>> Stashed changes

@Controller
public class appController {

    @GetMapping("/home")
<<<<<<< Updated upstream
    public String home(Model model) {
=======
    public String home(Model model,
                       @RequestParam(name="page", defaultValue="0") int page,
                       @RequestParam(name="size", defaultValue="5") int size,
                       @RequestParam(name="nom_search", defaultValue="") String nom) {
        ville ville = VilleRepository.getById(1L); // get the ville with id=1(khouribga)

        model.addAttribute("ville", ville);
        model.addAttribute("title", "Home");
>>>>>>> Stashed changes

        return "app/home";
    }

    @GetMapping("/historique")
    public String historique(Model model) {

        return "app/historique";
    }
    @GetMapping("/entreprises")
<<<<<<< Updated upstream
    public String entreprises(Model model) {
=======
    public String entreprises(Model model,
                              @RequestParam(name="page", defaultValue="0") int page,
                              @RequestParam(name="size", defaultValue="5") int size,
                              @RequestParam(name="nom_search", defaultValue="") String nom_search) {

        Optional<ville> ville = VilleRepository.findById(1L); // get the ville with id=1(khouribga)
//        List<entreprise> entreprises = EntrepriseRepository.findByVille(ville); // get the entreprises related to the ville
        List<entreprise> entreprises;
        if (nom_search.isEmpty()) {
            entreprises = EntrepriseRepository.findByVille(ville); // get the entreprises related to the ville
        } else {
           entreprises = EntrepriseRepository.findByNomContainingIgnoreCase(nom_search);
        }
        model.addAttribute("entreprises", entreprises);
        model.addAttribute("title", "Entreprises");
>>>>>>> Stashed changes

        return "app/entreprises";
    }

    @GetMapping("/suggestions")
    @ResponseBody
    public List<entreprise> suggestions(@RequestParam(name="term") String term) {
        Optional<ville> ville = VilleRepository.findById(1L);
        return EntrepriseRepository.findByNomContainingIgnoreCaseAndVille(term, ville);
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

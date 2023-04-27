package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.*;
import com.smartcity.affairesmodule.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;

@Controller
public class appController {

    @Autowired
    private VilleRepository VilleRepository;
    @Autowired
    private EntrepriseRepository EntrepriseRepository;
    @Autowired
    private CentreAffaireRepository CentreAffairesRepository;
    @Autowired
    private OrganisationRepository OrganisationRepository;

    @Autowired
    private historiqueRepository evenementsRepository;



    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name="page", defaultValue="0") int page,
                       @RequestParam(name="size", defaultValue="5") int size,
                       @RequestParam(name="nom_search", defaultValue="") String nom) {
        ville ville = VilleRepository.getById(1L); // get the ville with id=1(khouribga)

        model.addAttribute("ville", ville);
        model.addAttribute("title", "Home");
        return "app/home";
    }



    @GetMapping("/historique")
    public String historique(Model model) {
        List<Evenements> evenements = evenementsRepository.findAll();
        model.addAttribute("evenements", evenements);
        return "app/historique";
    }
    @GetMapping("/entreprises")
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
        return "app/entreprises";
    }

    @GetMapping("/entreprise")
    public String entreprises(Model model, @RequestParam(name = "id") Long id) {
        entreprise entreprise = EntrepriseRepository.getById(id);
        model.addAttribute("entreprise", entreprise);
        return "app/entreprise";
    }

    @GetMapping("/suggestions")
    @ResponseBody
    public List<entreprise> suggestions(@RequestParam(name="term") String term) {
        Optional<ville> ville = VilleRepository.findById(1L);
        return EntrepriseRepository.findByNomContainingIgnoreCaseAndVille(term, ville);
    }

    @GetMapping("/affaires")
    public String affaires(Model model) {
        List<centreAffaires> centresAffaires = CentreAffairesRepository.findAll();
        model.addAttribute("centresAffaires", centresAffaires);
        return "app/affaires";
    }

    @GetMapping("/centre-affaires")
    public String affaires(Model model, @RequestParam(name = "id") Long id) {
        centreAffaires centreAffaires = CentreAffairesRepository.getById(id);
        model.addAttribute("centreAffaires", centreAffaires);
        return "app/centreAffaires";
    }

    @GetMapping("/organisations")
    public String organisations(Model model) {
        List<organisation> organisations = OrganisationRepository.findAll();
        model.addAttribute("organisations", organisations);
        return "app/organisations";
    }

    @GetMapping("/organisation")
    public String organisations(Model model, @RequestParam(name = "id") Long id) {
        organisation organisation = OrganisationRepository.getById(id);
        model.addAttribute("organisation", organisation);
        return "app/organisation";
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

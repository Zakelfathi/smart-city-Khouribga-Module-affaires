package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.organisme;
import com.smartcity.affairesmodule.entities.ville;
import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import com.smartcity.affairesmodule.repositories.OrganismeRepository;
import com.smartcity.affairesmodule.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class dashboardController {

    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private OrganismeRepository organismRepository;
    @RequestMapping(value = "/admin/dashboard")
    public String index(Model model) {

        model.addAttribute("activePage", "dashboard");

        long numberOfEnterprises = entrepriseRepository.count();
        model.addAttribute("numberOfEnterprises", numberOfEnterprises);

        long numberOfOrganisms = organismRepository.count();
        model.addAttribute("numberOfOrganisms", numberOfOrganisms);

        // Retrieve the entreprise with the highest chiffre_affaires
        entreprise entreprise = entrepriseRepository.findFirstByOrderByChiffreAffairesDesc();
        if (entreprise != null) {
            model.addAttribute("highestChiffreAffaires", entreprise.getChiffreAffaires());
            organisme organisme = organismRepository.findById(entreprise.getId()).orElse(null);
            if (organisme != null) {
                model.addAttribute("highestChiffreAffairesOrganisme", organisme.getNom());
            }
        }



        return "dashboard/home";
    }

    @RequestMapping(value="/editor/edit-organisme")
    public String organismeView(Model model, Long id) {
        organisme organisme = organismRepository.getById(id);
        model.addAttribute("title", organisme.getNom()+" view");
        model.addAttribute("organisme", organisme);
        return "/dashboard/organismeView";
    }
}

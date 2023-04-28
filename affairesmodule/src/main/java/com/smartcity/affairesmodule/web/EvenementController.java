package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.Evenements;
import com.smartcity.affairesmodule.entities.organisation;
import com.smartcity.affairesmodule.repositories.historiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EvenementController {

    @Autowired
    private historiqueRepository evenementsRepository;

    @RequestMapping(value = "/admin/evenements", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="nom", defaultValue="") String nom
    )
    {
        Page<Evenements> pageEvenements = evenementsRepository.chercher("%"+nom+"%", PageRequest.of(page,size));
        model.addAttribute("listEvenements", pageEvenements.getContent());
        int[] pages = new int[pageEvenements.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        model.addAttribute("activePage", "Evenements");
        return "dashboard/listEvenements";
    }

    @RequestMapping("/admin/add-evenement")
    public String formEvenement(Model model) {
        model.addAttribute("evenement", new Evenements());
        model.addAttribute("title", "Ajouter Evenement");
        model.addAttribute("activePage", "Evenements");
        return "/dashboard/formEvenement";
    }

    @PostMapping("/admin/saveEvenement")
    public String saveEvenement(Evenements evenement, Model model) {
        evenementsRepository.save(evenement);
        model.addAttribute("activePage", "Evenements");
        return "redirect:/admin/evenements";
    }

    @RequestMapping(value = "/admin/edit-evenement", method = RequestMethod.GET)
    public String editOrganisation(Model model, Long id) {
        Evenements evenement = evenementsRepository.getById(id);
        model.addAttribute("evenement", evenement);
        model.addAttribute("title", "Modifier Evenement");
        model.addAttribute("activePage", "Evenements");
        return "dashboard/formEvenement";
    }

    @RequestMapping(value="/admin/delete-evenement",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        evenementsRepository.deleteById(id);
        return "redirect:/admin/evenements?page="+page+"&size="+size+"&nom="+nom;
    }
}

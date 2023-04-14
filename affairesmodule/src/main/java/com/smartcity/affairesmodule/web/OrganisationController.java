package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.organisation;
import com.smartcity.affairesmodule.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @RequestMapping(value = "/admin/organisations", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="nom", defaultValue="") String nom
    )
    {
        Page<organisation> pageOrganisations = organisationRepository.chercher("%"+nom+"%", PageRequest.of(page,size));
        model.addAttribute("listOrganisations", pageOrganisations.getContent());
        int[] pages = new int[pageOrganisations.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        return "dashboard/listOrganisations";
    }

    @RequestMapping(value = "/admin/add-organisation", method = RequestMethod.GET)
    public String formOrganisation(Model model){
        model.addAttribute("organisation", new organisation());
        model.addAttribute("title", "Ajouter Organisation");
        return "dashboard/formOrganisation";
    }

    @RequestMapping(value = "/admin/saveOrganisation", method = RequestMethod.POST)
    public String saveOrganisation(Model model, organisation organisation) {
        organisationRepository.save(organisation);
        return "redirect:/admin/organisations";
    }

    @RequestMapping(value = "/admin/edit-organisation", method = RequestMethod.GET)
    public String editOrganisation(Model model, Long id) {
        organisation organisation = organisationRepository.getById(id);
        model.addAttribute("organisation", organisation);
        model.addAttribute("title", "Modifier Organisation");
        return "dashboard/formOrganisation";
    }

    @RequestMapping(value="/admin/delete-organisation",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        organisationRepository.deleteById(id);
        return "redirect:/admin/organisations?page="+page+"&size="+size+"&nom="+nom;
    }
}

package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.centreAffaires;
import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.repositories.CentreAffaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CentresAffairesController {

    @Autowired
    private CentreAffaireRepository centreAffaireRepository;

    @RequestMapping(value = "/admin/centres-affaires", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="nom", defaultValue="") String nom
    )
    {
        Page<entreprise> pageCentresAffaires = centreAffaireRepository.chercher("%"+nom+"%", PageRequest.of(page,size));
        model.addAttribute("listCentresAffaires", pageCentresAffaires.getContent());
        int[] pages = new int[pageCentresAffaires.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        model.addAttribute("activePage", "centres-affaires");
        return "dashboard/listCentresAffaires";
    }

    @RequestMapping(value = "/admin/add-centre-affaires", method = RequestMethod.GET)
    public String formCentreAffaire(Model model){
        model.addAttribute("centreAffaires", new centreAffaires());
        model.addAttribute("title", "Ajouter Centre Affaires");
        model.addAttribute("activePage", "centres-affaires");
        return "dashboard/formCentreAffaires";
    }

    @RequestMapping(value = "/admin/saveCentreAffaires", method = RequestMethod.POST)
    public String saveCentreAffaire(Model model, centreAffaires centreAffaires) {
        centreAffaireRepository.save(centreAffaires);
        return "redirect:/admin/centres-affaires";
    }

    @RequestMapping(value = "/admin/edit-centre-affaires", method = RequestMethod.GET)
    public String editEntreprise(Model model, Long id) {
        centreAffaires centreAffaires = centreAffaireRepository.getById(id);
        model.addAttribute("centreAffaires", centreAffaires);
        model.addAttribute("title", "Modifier Centre Affaires");
        model.addAttribute("activePage", "centres-affaires");
        return "dashboard/formCentreAffaires";
    }

    @RequestMapping(value="/admin/delete-centre-affaires",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        centreAffaireRepository.deleteById(id);
        return "redirect:/admin/centres-affaires?page="+page+"&size="+size+"&nom="+nom;
    }
}

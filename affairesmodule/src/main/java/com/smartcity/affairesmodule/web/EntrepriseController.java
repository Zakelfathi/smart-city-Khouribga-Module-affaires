package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartcity.affairesmodule.entities.entreprise;

@Controller
public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @RequestMapping(value = "/admin/entreprises", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="nom", defaultValue="") String nom
                    )
    {
        Page<entreprise> pageEntreprises = entrepriseRepository.chercher("%"+nom+"%", PageRequest.of(page,size));
        model.addAttribute("listEntreprises", pageEntreprises.getContent());
        int[] pages = new int[pageEntreprises.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        return "dashboard/listEntreprises";
    }

    @RequestMapping(value = "/admin/add-entreprise", method = RequestMethod.GET)
    public String formEntreprise(Model model){
        model.addAttribute("entreprise", new entreprise());
        model.addAttribute("title", "Ajouter Entreprise");
        return "dashboard/formEntreprise";
    }

    @RequestMapping(value = "/admin/saveEntreprise", method = RequestMethod.POST)
    public String saveEntreprise(Model model, entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return "redirect:/admin/entreprises";
    }

    @RequestMapping(value = "/admin/edit-entreprise", method = RequestMethod.GET)
    public String editEntreprise(Model model, Long id) {
        entreprise entreprise = entrepriseRepository.getById(id);
        model.addAttribute("entreprise", entreprise);
        model.addAttribute("title", "Modifier Entreprise");
        return "dashboard/formEntreprise";
    }

    @RequestMapping(value="/admin/delete-entreprise",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        entrepriseRepository.deleteById(id);
        return "redirect:/admin/entreprises?page="+page+"&size="+size+"&nom="+nom;
    }
}

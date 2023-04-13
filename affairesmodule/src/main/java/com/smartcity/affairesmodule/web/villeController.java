package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.ville;
import com.smartcity.affairesmodule.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class villeController {

    @Autowired
    private VilleRepository villeRepository;

    @RequestMapping(value = "/admin/villes", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="nom", defaultValue="") String nom
    )
    {
        Page<entreprise> pageVilles = villeRepository.chercher("%"+nom+"%", PageRequest.of(page,size));
        model.addAttribute("listVilles", pageVilles.getContent());
        int[] pages = new int[pageVilles.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        return "dashboard/listVilles";
    }

    @RequestMapping(value = "/admin/add-ville", method = RequestMethod.GET)
    public String formVille(Model model){
        model.addAttribute("ville", new ville());
        model.addAttribute("title", "Ajouter Ville");
        return "dashboard/formVille";
    }

    @RequestMapping(value = "/admin/saveVille", method = RequestMethod.POST)
    public String saveVille(Model model, ville ville) {
        villeRepository.save(ville);
        return "redirect:/admin/villes";
    }

    @RequestMapping(value = "/admin/edit-ville", method = RequestMethod.GET)
    public String editVille(Model model, Long id) {
        ville ville = villeRepository.getById(id);
        model.addAttribute("ville", ville);
        model.addAttribute("title", "Modifier Ville");
        return "dashboard/formVille";
    }

    @RequestMapping(value="/admin/delete-ville",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        villeRepository.deleteById(id);
        return "redirect:/admin/villes?page="+page+"&size="+size+"&nom="+nom;
    }
}

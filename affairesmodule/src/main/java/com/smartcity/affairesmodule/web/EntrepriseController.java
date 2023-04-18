package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartcity.affairesmodule.entities.entreprise;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Clock;
import java.util.Objects;

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
        model.addAttribute("activePage", "entreprises");
        return "dashboard/listEntreprises";
    }

    @RequestMapping(value = "/admin/add-entreprise", method = RequestMethod.GET)
    public String formEntreprise(Model model){
        model.addAttribute("entreprise", new entreprise());
        model.addAttribute("title", "Ajouter Entreprise");
        model.addAttribute("activePage", "entreprises");
        return "dashboard/formEntreprise";
    }

    @RequestMapping(value = "/admin/saveEntreprise", method = RequestMethod.POST)
    public String saveEntreprise(Model model, entreprise entreprise, @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        entreprise.setLogo(fileName);
        entreprise sevedEntreprise = entrepriseRepository.save(entreprise);
        String uploadDir = "./images/Entreprises/"+sevedEntreprise.getId();
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file : "+fileName);
        }
        return "redirect:/admin/entreprises";
    }

    @RequestMapping(value = "/admin/edit-entreprise", method = RequestMethod.GET)
    public String editEntreprise(Model model, Long id) {
        entreprise entreprise = entrepriseRepository.getById(id);
        model.addAttribute("entreprise", entreprise);
        model.addAttribute("title", "Modifier Entreprise");
        model.addAttribute("activePage", "entreprises");
        return "dashboard/formEntreprise";
    }

    @RequestMapping(value="/admin/delete-entreprise",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        entrepriseRepository.deleteById(id);
        return "redirect:/admin/entreprises?page="+page+"&size="+size+"&nom="+nom;
    }
}

package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.centreAffaires;
import com.smartcity.affairesmodule.entities.organisation;
import com.smartcity.affairesmodule.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
        model.addAttribute("activePage", "organisations");
        return "dashboard/listOrganisations";
    }

    @RequestMapping(value = "/admin/add-organisation", method = RequestMethod.GET)
    public String formOrganisation(Model model){
        model.addAttribute("organisation", new organisation());
        model.addAttribute("title", "Ajouter Organisation");
        model.addAttribute("activePage", "organisations");
        return "dashboard/formOrganisation";
    }

    @RequestMapping(value = "/admin/saveOrganisation", method = RequestMethod.POST)
    public String saveOrganisation(Model model, organisation organisation, @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            organisation.setLogo(fileName);
            organisation sevedOrganisation = organisationRepository.save(organisation);
            String uploadDir = "./images/Organismes/" + sevedOrganisation.getId();
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
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
                throw new IOException("Could not save uploaded file : " + fileName);
            }
        }else
            organisationRepository.save(organisation);
        return "redirect:/admin/organisations";
    }

    @RequestMapping(value = "/admin/edit-organisation", method = RequestMethod.GET)
    public String editOrganisation(Model model, Long id) {
        organisation organisation = organisationRepository.getById(id);
        model.addAttribute("organisation", organisation);
        model.addAttribute("title", "Modifier Organisation");
        model.addAttribute("activePage", "organisations");
        return "dashboard/formOrganisation";
    }

    @RequestMapping(value="/admin/delete-organisation",method=RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        organisationRepository.deleteById(id);
        return "redirect:/admin/organisations?page="+page+"&size="+size+"&nom="+nom;
    }
}

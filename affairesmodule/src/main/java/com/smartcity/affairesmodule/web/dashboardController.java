package com.smartcity.affairesmodule.web;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.organisme;
import com.smartcity.affairesmodule.entities.photoType;
import com.smartcity.affairesmodule.entities.photo;
import com.smartcity.affairesmodule.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class dashboardController {

    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private OrganismeRepository organismRepository;
    @Autowired
    private PhotoTypeRepository photoTypeRepository;
    @Autowired
    private PhotoRepository photoRepository;

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



        return "/dashboard/home";
    }

    @RequestMapping(value="/editor/edit-organisme")
    public String organismeView(Model model, Long id) {
        organisme organisme = organismRepository.getById(id);
        model.addAttribute("title", organisme.getNom()+" view");
        model.addAttribute("organisme", organisme);
        List<photoType> listPhotoTypes = photoTypeRepository.findAll();
        model.addAttribute("listPhotoTypes", listPhotoTypes);
        model.addAttribute("activePage", "dashboard");
        return "/dashboard/organismeView";
    }

    @RequestMapping(value="/editor/update-photo", method = RequestMethod.POST)
    public String updatePhoto(Model model,
                              @RequestParam("photoType") Long photoType,
                              @RequestParam("id") Long id,
                              @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        System.out.println(photoType);
        if(!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            organisme organisme = organismRepository.getById(id);
            photoType type = photoTypeRepository.getReferenceById(photoType);
            if(type.getId() == 1) {
                organisme.setLogo(fileName);
            }
            else {
                photo photo = new photo();
                photo.setUrl(fileName);
                photo.setType(type);
                photo.setOrganisme(organisme);
                photoRepository.save(photo);
            }
            organisme sevedOrganisme = organismRepository.save(organisme);
            String uploadDir = "./images/Organismes/" + sevedOrganisme.getId();
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
        }
        return "redirect:/editor/edit-organisme?id="+id;
    }

    @RequestMapping(value = "/editor/delete-carousel-photo", method = RequestMethod.GET)
    public String deleteCarouselPhoto(Model model, Long id, Long organismeId) {
        photoRepository.deleteById(id);
        return "redirect:/editor/edit-organisme?id="+organismeId;
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "/app/login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/app/login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/login?logout=true";
    }

    @RequestMapping("/default")
    public String successPage(HttpServletRequest request) {
        if(request.isUserInRole("ADMIN")) {
            return "redirect:/admin/dashboard";
        } else if (request.isUserInRole("EDITOR")) {
            return "redirect:/editor/edit-organisme?id=1";
        }
        else {
            return "redirect:/home";
        }
    }

}

package com.smartcity.affairesmodule;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.ville;
import com.smartcity.affairesmodule.entities.organisme;
import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import com.smartcity.affairesmodule.repositories.VilleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AffairesmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AffairesmoduleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(VilleRepository villeRepository, EntrepriseRepository entrepriseRepository) {
		return args -> {
			ville v = new ville("Khouribga", "Béni Mellal - Khenifra", "Maroc", 542125);
			villeRepository.save(v);
			entreprise e = new entreprise();
			e.setNom("OCP");
			e.setDescription("");
			e.setDateCreation(new Date(1920, 8, 7));
			e.setAdresse("2, rue Al Abtal, Hay Erraha, Casablanca");
			e.setSiteweb("www.ocpgroup.ma");
			e.setVille(v);
			e.setChiffreAffaires(11040000000.0);
			e.setNombreEmployes(20980);
			e.setSecteurActivite("Industrielle");
			entrepriseRepository.save(e);
		};
	}
}

package com.smartcity.affairesmodule;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.photoType;
import com.smartcity.affairesmodule.entities.ville;
import com.smartcity.affairesmodule.repositories.EntrepriseRepository;
import com.smartcity.affairesmodule.repositories.PhotoTypeRepository;
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
	CommandLineRunner start(VilleRepository villeRepository, EntrepriseRepository entrepriseRepository, PhotoTypeRepository photoTypeRepository) {
		return args -> {
			ville v = new ville("Khouribga", "Béni Mellal - Khenifra", "Maroc", 542125);
			v.setDescription("Khouribga est une ville du Maroc qui se situe à 120 km au sud-est de Casablanca. Cette cité minière est considérée comme la plus importante zone de production de phosphates du monde. L’Office chérifien des phosphates (OCP), la première entreprise publique du Maroc, exploite la zone minière du bassin d'Ouled Abdoun et gère en partie les infrastructures sportives et sociales de la ville. Khouribga est connue par ses activités culturelles comme l'organisation de festivals et de journées culturelles et artistiques, pour ses activités sportives : football, tennis, rugby à XV, golf, natation, handball, basketball, volleyball, karting, athlétisme…, la plupart de ces clubs dépendent de l'Olympique Club de Khouribga (OCK) et le Hassania de Khouribga (HUSK).");
			villeRepository.save(v);
			entreprise e = new entreprise();
			e.setNom("OCP");
			e.setDescription("Le groupe OCP, fondé le 7 août 1920 au Maroc et transformé en 2008 en une société anonyme, est le premier exportateur de phosphate brut, d’acide phosphorique et d’engrais phosphatés dans le monde.");
			e.setFormJuridique("SA");
			e.setDateCreation(new Date(20, 8, 7));
			e.setAdresse("2, rue Al Abtal, Hay Erraha, Casablanca");
			e.setSiteweb("www.ocpgroup.ma");
			e.setVille(v);
			e.setChiffreAffaires(11040000000.0);
			e.setNombreEmployes(20980);
			e.setSecteurActivite("Industrielle");
			e.setLogo("logo.png");
			entrepriseRepository.save(e);

			entreprise entreprise1 = new entreprise();
			entreprise1.setNom("Microsoft");
			entreprise1.setFormJuridique("SA");
			entreprise1.setDescription("Microsoft Corporation est une entreprise multinationale américaine de technologie qui développe, fabrique, soutient et vend des logiciels informatiques, des produits électroniques et des ordinateurs personnels.");
			entreprise1.setDateCreation(new Date(75, 4, 4));
			entreprise1.setAdresse("One Microsoft Way, Redmond, WA 98052, États-Unis");
			entreprise1.setSiteweb("www.microsoft.com");
			entreprise1.setVille(v);
			entreprise1.setChiffreAffaires(168100000000.0);
			entreprise1.setNombreEmployes(181000);
			entreprise1.setSecteurActivite("Technologie");
			entreprise1.setLogo("logo.png");
			entrepriseRepository.save(entreprise1);

			entreprise entreprise2 = new entreprise();
			entreprise2.setNom("Apple");
			entreprise2.setFormJuridique("SA");
			entreprise2.setDescription("Apple Inc. est une entreprise américaine qui conçoit et vend des produits électroniques grand public, des logiciels informatiques et des services en ligne.");
			entreprise2.setDateCreation(new Date(76, 4, 1));
			entreprise2.setAdresse("1 Infinite Loop, Cupertino, CA 95014, États-Unis");
			entreprise2.setSiteweb("www.apple.com");
			entreprise2.setVille(v);
			entreprise2.setChiffreAffaires(274500000000.0);
			entreprise2.setNombreEmployes(147000);
			entreprise2.setSecteurActivite("Technologie");
			entreprise2.setLogo("logo.png");
			entrepriseRepository.save(entreprise2);

			entreprise entreprise3 = new entreprise();
			entreprise3.setNom("Amazon");
			entreprise3.setFormJuridique("SA");
			entreprise3.setDescription("Amazon.com, Inc. est une entreprise américaine de commerce électronique et de services de cloud computing.");
			entreprise3.setDateCreation(new Date(94, 7, 5));
			entreprise3.setAdresse("410 Terry Ave N, Seattle, WA 98109, États-Unis");
			entreprise3.setSiteweb("www.amazon.com");
			entreprise3.setVille(v);
			entreprise3.setChiffreAffaires(386000000000.0);
			entreprise3.setNombreEmployes(1173000);
			entreprise3.setSecteurActivite("Commerce électronique");
			entreprise3.setLogo("logo.png");
			entrepriseRepository.save(entreprise3);

			entreprise entreprise4 = new entreprise();
			entreprise4.setNom("Alphabet");
			entreprise4.setFormJuridique("SA");
			entreprise4.setDescription("Alphabet Inc. est une entreprise holding américaine qui regroupe plusieurs filiales spécialisées dans les technologies de l'information et de la communication, dont Google.");
			entreprise4.setDateCreation(new Date(115, 10, 2));
			entreprise4.setAdresse("1600 Amphitheatre Pkwy, Mountain View, CA 94043, États-Unis");
			entreprise4.setSiteweb("www.abc.xyz");
			entreprise4.setVille(v);
			entreprise4.setChiffreAffaires(181690000000.0);
			entreprise4.setNombreEmployes(139995);
			entreprise4.setSecteurActivite("Technologie");
			entreprise4.setLogo("logo.png");
			entrepriseRepository.save(entreprise4);

			entreprise entreprise5 = new entreprise();
			entreprise5.setNom("Tesla");
			entreprise5.setFormJuridique("SA");
			entreprise5.setDescription("Tesla, Inc. est une entreprise américaine spécialisée dans la conception et la production de voitures électriques haut de gamme, de systèmes de stockage d'énergie et de panneaux solaires.");
			entreprise5.setDateCreation(new Date(103, 7, 1));
			entreprise5.setAdresse("3500 Deer Creek Rd, Palo Alto, CA 94304, États-Unis");
			entreprise5.setSiteweb("www.tesla.com");
			entreprise5.setVille(v);
			entreprise5.setChiffreAffaires(181690000000.0);
			entreprise5.setNombreEmployes(139995);
			entreprise5.setSecteurActivite("Technologie");
			entreprise5.setLogo("logo.png");
			entrepriseRepository.save(entreprise5);

			photoTypeRepository.save(new photoType(1L, "Logo"));
			photoTypeRepository.save(new photoType(2L, "Couverture"));
			photoTypeRepository.save(new photoType(3L, "Description"));
			photoTypeRepository.save(new photoType(4L, "Carousel"));
		};
	}
}

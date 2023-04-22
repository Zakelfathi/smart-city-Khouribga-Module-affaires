package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class organisme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_organisme;
    String nom;
    String description;
    String adresse;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    String email;
    String tel;
    String siteweb;
    String logo;
    @OneToMany(mappedBy = "organisme", fetch = FetchType.LAZY)
    List<photo> photos;
    @ManyToOne
    ville ville;

    public organisme() {
    }

    public organisme(Long id, String nom, String description, String adresse, Date dateCreation, String email, String tel, String siteweb, String logo, List<photo> photos, com.smartcity.affairesmodule.entities.ville ville) {
        this.id_organisme = id;
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.dateCreation = dateCreation;
        this.email = email;
        this.tel = tel;
        this.siteweb = siteweb;
        this.logo = logo;
        this.photos = photos;
        this.ville = ville;
    }

    public Long getId() {
        return id_organisme;
    }

    public void setId(Long id) {
        this.id_organisme = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<photo> photos) {
        this.photos = photos;
    }

    public com.smartcity.affairesmodule.entities.ville getVille() {
        return ville;
    }

    public void setVille(com.smartcity.affairesmodule.entities.ville ville) {
        this.ville = ville;
    }

    @Transient
    public String getLogoPath() {
        if(logo == null || id_organisme == null) {
            return null;
        }
        return "../../../../images/Organismes/"+id_organisme+"/"+logo;
    }

    @Transient
    public String getCouverturePath() {
        for (photo photo : photos) {
            if(photo.getType().getId() == 2)
                return "../../../../images/Organismes/"+id_organisme+"/"+photo.getUrl();
        }
        return getLogoPath();
    }

    @Transient
    public String getDescriptionPhotoPath() {
        for (photo photo : photos) {
            if(photo.getType().getId() == 3)
                return "../../../../images/Organismes/"+id_organisme+"/"+photo.getUrl();
        }
        return getLogoPath();
    }

    @Transient
    public List<photo> getCarouselPhotos() {
        List<photo> photosCarousel = new ArrayList<photo>();
        for (photo photo : photos) {
            if(photo.getType().getId() == 4)
                photosCarousel.add(photo);
        }
        return photosCarousel;
    }
}

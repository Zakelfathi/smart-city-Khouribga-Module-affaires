package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class organisme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String description;
    String adresse;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    String email;
    String tel;
    String siteweb;
    String logo;
    @OneToMany(mappedBy = "organisme")
    List<photo> photos;
    @ManyToOne
    ville ville;

}

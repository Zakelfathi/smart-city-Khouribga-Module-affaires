package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photoTypes")
public class photoType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    List<photo> photos;

    public photoType() {
    }

    public photoType(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Evenements {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(length = 10000000)
    private String description;
    private String date;
    @ManyToOne
    private ville ville;

    public Evenements() {

    }

    public Evenements(Long id, String nom, String description, String date, com.smartcity.affairesmodule.entities.ville ville) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.ville = ville;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public com.smartcity.affairesmodule.entities.ville getVille() {
        return ville;
    }

    public void setVille(com.smartcity.affairesmodule.entities.ville ville) {
        this.ville = ville;
    }
}


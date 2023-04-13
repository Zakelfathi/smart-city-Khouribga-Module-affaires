package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Historique extends ville {
    private String histoire;
    private int anneeDeCreation;

    public Historique() {
        super();
    }

    public Historique(Long id_ville, String nom, String province, String pays, int population, List<organisme> organismes, String histoire, int anneeDeCreation) {
        super(id_ville, nom, province, pays, population, organismes);
        this.histoire = histoire;
        this.anneeDeCreation = anneeDeCreation;
    }

    public Historique(String nom, String province, String pays, int population, String histoire, int anneeDeCreation) {
        super(nom, province, pays, population);
        this.histoire = histoire;
        this.anneeDeCreation = anneeDeCreation;
    }

    public String getHistoire() {
        return histoire;
    }

    public void setHistoire(String histoire) {
        this.histoire = histoire;
    }

    public int getAnneeDeCreation() {
        return anneeDeCreation;
    }

    public void setAnneeDeCreation(int anneeDeCreation) {
        this.anneeDeCreation = anneeDeCreation;
    }
}

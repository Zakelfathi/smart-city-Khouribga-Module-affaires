package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class VueIndustrielles extends ville {
    private String industrie;
    private int nbEntreprises;

    public VueIndustrielles() {
        super();
    }

    public VueIndustrielles(Long id_ville, String nom, String province, String pays, int population, List<organisme> organismes, String industrie, int nbEntreprises) {
        super(id_ville, nom, province, pays, population, organismes);
        this.industrie = industrie;
        this.nbEntreprises = nbEntreprises;
    }

    public VueIndustrielles(String nom, String province, String pays, int population, String industrie, int nbEntreprises) {
        super(nom, province, pays, population);
        this.industrie = industrie;
        this.nbEntreprises = nbEntreprises;
    }

    public String getIndustrie() {
        return industrie;
    }

    public void setIndustrie(String industrie) {
        this.industrie = industrie;
    }

    public int getNbEntreprises() {
        return nbEntreprises;
    }

    public void setNbEntreprises(int nbEntreprises) {
        this.nbEntreprises = nbEntreprises;
    }
}

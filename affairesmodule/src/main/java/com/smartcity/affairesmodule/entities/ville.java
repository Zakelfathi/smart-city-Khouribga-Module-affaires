package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ville {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String province;
    private String pays;
    private int population;
    @OneToMany(mappedBy = "ville")
    private List<organisme> organismes;

    public ville() {
    }

    public ville(Long id, String nom, String province, String pays, int population, List<organisme> organismes) {
        this.id = id;
        this.nom = nom;
        this.province = province;
        this.pays = pays;
        this.population = population;
        this.organismes = organismes;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Collection<organisme> getOrganismes() {
        return organismes;
    }

    public void setOrganismes(List<organisme> organismes) {
        this.organismes = organismes;
    }
}

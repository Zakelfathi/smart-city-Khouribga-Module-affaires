package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ville {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ville;
    private String nom;
    private String province;
    private String pays;
    private int population;
    @Column( length = 100000 )
    private String description;
    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY)
    private List<organisme> organismes;
    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY)
    private List<Evenements> evenements;

    public ville() {
    }

    public ville(Long id, String nom, String province, String pays, int population, String description, List<organisme> organismes) {
        this.id_ville = id;
        this.nom = nom;
        this.province = province;
        this.pays = pays;
        this.population = population;
        this.description = description;
        this.organismes = organismes;
    }

    public ville(String nom, String province, String pays, int population) {
        this.nom = nom;
        this.province = province;
        this.pays = pays;
        this.population = population;
    }

    public Long getId() {
        return id_ville;
    }

    public void setId(Long id) {
        this.id_ville = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

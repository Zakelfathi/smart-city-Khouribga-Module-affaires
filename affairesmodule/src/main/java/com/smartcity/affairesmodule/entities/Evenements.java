package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Evenements extends ville {
    private String description;
    private String date;

    public Evenements() {
        super();
    }

    public Evenements(Long id_ville, String nom, String province, String pays, int population, String description_ville, List<organisme> organismes, String description, String date) {
        super(id_ville, nom, province, pays, population, description_ville, organismes);
        this.description = description;
        this.date = date;
    }

    public Evenements(String nom, String province, String pays, int population, String description, String date) {
        super(nom, province, pays, population);
        this.description = description;
        this.date = date;
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
}


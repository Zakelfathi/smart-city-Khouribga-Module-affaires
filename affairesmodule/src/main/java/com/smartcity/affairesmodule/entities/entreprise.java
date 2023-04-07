package com.smartcity.affairesmodule.entities;

import javax.persistence.*;

@Entity
public class entreprise extends organisme {

    String secteurActivite;
    Double chiffreAffaires;
    int nombreEmployes;

    public entreprise() {
    }

    public entreprise(String secteurActivite, Double chiffreAffaires, int nombreEmployes) {
        this.secteurActivite = secteurActivite;
        this.chiffreAffaires = chiffreAffaires;
        this.nombreEmployes = nombreEmployes;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public Double getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(Double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNombreEmployes() {
        return nombreEmployes;
    }

    public void setNombreEmployes(int nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }
}

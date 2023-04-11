package com.smartcity.affairesmodule.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class entreprise extends organisme {

    String formJuridique;
    String secteurActivite;
    Double chiffreAffaires;
    int nombreEmployes;

    public entreprise() {
    }

    public entreprise(String formJuridique, String secteurActivite, Double chiffreAffaires, int nombreEmployes) {
        this.formJuridique = formJuridique;
        this.secteurActivite = secteurActivite;
        this.chiffreAffaires = chiffreAffaires;
        this.nombreEmployes = nombreEmployes;
    }

    public String getFormJuridique() {
        return formJuridique;
    }

    public void setFormJuridique(String formJuridique) {
        this.formJuridique = formJuridique;
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

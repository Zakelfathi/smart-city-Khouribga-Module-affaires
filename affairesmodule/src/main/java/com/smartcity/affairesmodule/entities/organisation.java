package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;

@Entity
public class organisation extends organisme {

    String secteurActivite;

    public organisation() {
    }

    public organisation(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }
}

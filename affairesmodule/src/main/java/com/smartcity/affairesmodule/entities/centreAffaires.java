package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;

@Entity
public class centreAffaires extends organisme {

    private int nombreBureauxDisponibles;
    private double tarifHoraire;

    public centreAffaires() {
    }

    public centreAffaires(int nombreBureauxDisponibles, double tarifHoraire) {
        this.nombreBureauxDisponibles = nombreBureauxDisponibles;
        this.tarifHoraire = tarifHoraire;
    }

    public int getNombreBureauxDisponibles() {
        return nombreBureauxDisponibles;
    }

    public void setNombreBureauxDisponibles(int nombreBureauxDisponibles) {
        this.nombreBureauxDisponibles = nombreBureauxDisponibles;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }
}

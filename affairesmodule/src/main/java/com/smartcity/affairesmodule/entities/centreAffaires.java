package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;

@Entity
public class centreAffaires extends organisme {

    private int nombreBureauxDisponibles;
    private double tarifHoraire;

}

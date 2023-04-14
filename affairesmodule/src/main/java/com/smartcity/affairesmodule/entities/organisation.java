package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;

@Entity
public class organisation extends organisme {

    private int numberMembers;

    private String mission;

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public organisation() {
    }

    public organisation(int numberMembers, String mission) {
        this.numberMembers = numberMembers;
        this.mission = mission;
    }

    public int getNumberMembers() {
        return numberMembers;
    }

    public void setNumberMembers(int numberMembers) {
        this.numberMembers = numberMembers;
    }
}

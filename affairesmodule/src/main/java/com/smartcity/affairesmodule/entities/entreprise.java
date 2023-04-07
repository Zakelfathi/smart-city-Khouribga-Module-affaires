package com.smartcity.affairesmodule.entities;

import javax.persistence.*;

@Entity
public class entreprise extends organisme {

    String secteurActivite;
    Double chiffreAffaires;
    int nombreEmployes;

}

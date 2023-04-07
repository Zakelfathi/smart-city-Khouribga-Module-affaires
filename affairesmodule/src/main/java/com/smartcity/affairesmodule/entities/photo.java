package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String url;
    @ManyToOne
    organisme organisme;
}

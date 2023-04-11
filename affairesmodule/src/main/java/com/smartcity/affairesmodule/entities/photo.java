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

    public photo() {
    }

    public photo(Long id, String url, com.smartcity.affairesmodule.entities.organisme organisme) {
        this.id = id;
        this.url = url;
        this.organisme = organisme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.smartcity.affairesmodule.entities.organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(com.smartcity.affairesmodule.entities.organisme organisme) {
        this.organisme = organisme;
    }
}

package com.smartcity.affairesmodule.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_photo;
    String url;
    @ManyToOne
    organisme organisme;
    @ManyToOne
    photoType type;

    public photo() {
    }

    public photo(Long id, String url, com.smartcity.affairesmodule.entities.organisme organisme) {
        this.id_photo = id;
        this.url = url;
        this.organisme = organisme;
    }

    public Long getId() {
        return id_photo;
    }

    public void setId(Long id) {
        this.id_photo = id;
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

    public photoType getType() {
        return type;
    }

    public void setType(photoType type) {
        this.type = type;
    }
}

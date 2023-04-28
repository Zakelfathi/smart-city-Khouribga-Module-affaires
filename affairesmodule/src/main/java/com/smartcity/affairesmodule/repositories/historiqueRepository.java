package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.Evenements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface historiqueRepository extends JpaRepository<Evenements, Long> {

    @Query("select e from Evenements e where e.nom like :x")
    public Page chercher(@Param("x") String nom, Pageable pageable);

}

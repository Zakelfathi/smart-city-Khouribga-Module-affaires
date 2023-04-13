package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.centreAffaires;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CentreAffaireRepository extends JpaRepository<centreAffaires, Long> {

    @Query("select c from centreAffaires c where c.nom like :x")
    public Page chercher(@Param("x") String nom, Pageable pageable);




}

package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.organisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrganisationRepository extends JpaRepository<organisation, Long> {

    @Query("select o from organisation o where o.nom like :x")
    public Page chercher(@Param("x") String nom, Pageable pageable);




}

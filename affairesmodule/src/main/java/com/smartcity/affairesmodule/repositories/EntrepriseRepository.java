package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<entreprise, Long> {

    @Query("select e from entreprise e where e.nom like :x")
    public Page chercher(@Param("x") String nom, Pageable pageable);

    entreprise findFirstByOrderByChiffreAffairesDesc();




}

package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VilleRepository extends JpaRepository<ville, Long> {


    @Query("SELECT e FROM entreprise e WHERE LOWER(e.nom) LIKE LOWER(concat('%', :nom, '%'))")
    public Page<entreprise> chercher(@Param("nom") String nom, Pageable pageable);

}

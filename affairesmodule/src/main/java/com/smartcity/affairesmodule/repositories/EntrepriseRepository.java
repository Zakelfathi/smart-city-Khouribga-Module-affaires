package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.entreprise;
import com.smartcity.affairesmodule.entities.ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<entreprise, Long> {

    @Query("select e from entreprise e where e.nom like :x")
    public Page chercher(@Param("x") String nom, Pageable pageable);

    entreprise findFirstByOrderByChiffreAffairesDesc();

    List<entreprise> findByNomContains(String nom);

    Page<entreprise> findByNomContains(String nom, Pageable pageable);

    List<entreprise> findBySecteurActivite(String secteurActivite);

    List<entreprise> findByVille(Optional<ville> ville);
    entreprise getById(Long id);


    List<entreprise> findByNomContainingIgnoreCase(String nom);

    List<entreprise> findByNomContainingIgnoreCaseAndVille(String term, Optional<ville> ville);
}

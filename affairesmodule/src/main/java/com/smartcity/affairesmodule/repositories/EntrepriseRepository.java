package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<entreprise, Long> {
}

package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.Evenements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface historiqueRepository extends JpaRepository<Evenements, Long> {

}

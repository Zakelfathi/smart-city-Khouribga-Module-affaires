package com.smartcity.affairesmodule.repositories;

import com.smartcity.affairesmodule.entities.organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface OrganismeRepository extends JpaRepository<organisme, Long> {

}

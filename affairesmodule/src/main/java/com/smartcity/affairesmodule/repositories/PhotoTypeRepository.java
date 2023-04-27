package com.smartcity.affairesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcity.affairesmodule.entities.photoType;

public interface PhotoTypeRepository extends JpaRepository<photoType, Long> {
}

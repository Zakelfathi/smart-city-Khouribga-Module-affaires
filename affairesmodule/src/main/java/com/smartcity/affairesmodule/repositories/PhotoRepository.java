package com.smartcity.affairesmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcity.affairesmodule.entities.photo;

public interface PhotoRepository extends JpaRepository<photo, Long> {
}

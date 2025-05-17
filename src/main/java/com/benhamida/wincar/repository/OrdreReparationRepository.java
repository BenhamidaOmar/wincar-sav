package com.benhamida.wincar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benhamida.wincar.entities.OrdreReparation;

@Repository
public interface OrdreReparationRepository extends JpaRepository<OrdreReparation, Long> {

}

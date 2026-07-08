package com.viagens.rotaunica.repositories;

import com.viagens.rotaunica.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExcursionRepository extends JpaRepository<Excursion, UUID> {
}

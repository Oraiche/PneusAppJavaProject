package com.oraiche.pneus.repositories;

import com.oraiche.pneus.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne,Long> {
}

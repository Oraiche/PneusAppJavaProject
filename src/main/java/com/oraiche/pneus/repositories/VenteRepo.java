package com.oraiche.pneus.repositories;

import com.oraiche.pneus.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepo extends JpaRepository<Vente,Long> {
}

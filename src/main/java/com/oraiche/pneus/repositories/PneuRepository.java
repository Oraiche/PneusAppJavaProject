package com.oraiche.pneus.repositories;

import com.oraiche.pneus.entities.Pneu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PneuRepository extends JpaRepository <Pneu,Long> {
    List<Pneu> findAll();
    List<Pneu> findByMarque(String marque);
    List<Pneu> findByLargeur(int largeur);
    List<Pneu> findByMarqueAndLargeur(String marque,int largeur);
    List<Pneu> findByLargeurAndHauteur(int largeur,int hauteur);

   Pneu findFirstByLargeurAndHauteurAndMarque(int largeur,int hauteur,String marque);

    Pneu findFirstByLargeurAndHauteur(int largeur, int hauteur);
}

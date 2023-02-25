package com.oraiche.pneus.services;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;

import java.util.List;
import java.util.Map;

public interface Garage {
    int compteByMarque(String marque);
    int compteByLargeur(int largeur);
    Map<String,Double> prix(int largeur);
    double somme(List<Pneu> pneus);


}

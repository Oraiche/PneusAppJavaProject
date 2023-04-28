package com.oraiche.pneus.services;

import com.oraiche.pneus.entities.Pneu;

import java.util.List;
import java.util.Map;

public interface Garage {

    Pneu savePneu(Pneu pneu);
    int totalNumbPneus();
    double prixTotalPneus(List<Pneu> pneus);
    double prixPneu(int largeur,int hauteur,String marque);
    int compterPneusByMarqueAndLargeur(String marque, int largeur);

    int compterPneusBylargeurAndHauteur(int largeur, int hauteur);

    Pneu addPneu(Pneu pneu);
    List<Pneu> findPneusByMarque(String Marque);
    List<Pneu> findAllPneu();
    Pneu findPneuById(Long id);
    int compteByMarque(String marque);
    int compteByLargeur(int largeur);
    Map<String,List<Double>> prix(int largeur);
    Map<String, List<Double>> AffichePneus(List<Pneu> pneuList);
    double somme(int largeur);


}

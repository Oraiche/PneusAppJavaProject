package com.oraiche.pneus.services;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.entities.Vente;

import java.util.List;

public interface VenteInterface {

    void setPneusToVent(String marque);
    List<Pneu> pneusVendue(Long id);
    List<Vente> getVentes();
}

package com.oraiche.pneus.services;

import com.oraiche.pneus.PneusApplication;
import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GarageImp implements Garage{
    @Autowired
    private PneuRepository pneuRepository;



    @Override
    public int compteByMarque(String marque) {
        int nomber =pneuRepository.findByMarque(marque).size();
        return nomber;
    }

    @Override
    public int compteByLargeur( int largeur) {
        return pneuRepository.findByLargeur(largeur).size() ;
    }

    @Override
    public Map<String,Double> prix(int largeur) {
        Map<String,Double> prixMarque=new HashMap<String,Double>();
        List<Pneu> listP=pneuRepository.findByLargeur(largeur);
        for(Pneu p:listP) {
            prixMarque.put(p.getMarque(),p.getPrix());
        }
        return prixMarque ;
    }

    @Override
    public double somme(List<Pneu> pneus) {
        double s=0;
       for(Pneu p :pneus)
       {
           s=s+p.getPrix();
       }

        return s;
    }


}
